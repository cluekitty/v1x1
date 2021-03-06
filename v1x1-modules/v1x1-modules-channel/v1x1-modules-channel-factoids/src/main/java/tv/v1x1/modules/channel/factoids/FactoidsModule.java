package tv.v1x1.modules.channel.factoids;

import tv.v1x1.common.dto.core.Channel;
import tv.v1x1.common.dto.core.Permission;
import tv.v1x1.common.dto.core.Tenant;
import tv.v1x1.common.dto.messages.events.ChatMessageEvent;
import tv.v1x1.common.modules.RegisteredThreadedModule;
import tv.v1x1.common.scanners.i18n.I18nDefault;
import tv.v1x1.common.scanners.i18n.I18nDefaults;
import tv.v1x1.common.scanners.permission.DefaultGroup;
import tv.v1x1.common.scanners.permission.Permissions;
import tv.v1x1.common.scanners.permission.RegisteredPermission;
import tv.v1x1.common.util.commands.CommandDelegator;
import tv.v1x1.modules.channel.factoids.commands.FactCommand;
import tv.v1x1.modules.channel.factoids.config.FactoidsGlobalConfiguration;
import tv.v1x1.modules.channel.factoids.config.FactoidsUserConfiguration;

import java.util.Map;
import java.util.Set;

/**
 * @author Josh
 */
@Permissions(version = 1, value = {
        @RegisteredPermission(
                node = "factoids.useall",
                displayName = "Use All Factoids",
                description = "This gives you the ability to use all factoids.",
                defaultGroups = {DefaultGroup.OWNER, DefaultGroup.BROADCASTER, DefaultGroup.MODS}
        ),
        @RegisteredPermission(
                node = "fact.modify",
                displayName = "Modify Factoids",
                description = "This gives you the ability to modify all factoids.",
                defaultGroups = {DefaultGroup.OWNER, DefaultGroup.BROADCASTER, DefaultGroup.MODS}
        ),
        @RegisteredPermission(
                node = "factoids.use.{custompermission}",
                displayName = "Custom permissions for factoids",
                description = "This gives you the ability to use certain factoids."
        )
})
@I18nDefaults(version = 1, value = {
        @I18nDefault(
                key = "help.blurb",
                message = "Factoids are little bits of text you can call upon as a custom command",
                displayName = "Help Blurb",
                description = "Sent in response to !fact help"
        ),
        /* generic failures */
        @I18nDefault(
                key = "invalid.args",
                message = "%commander%, that command is missing something. Usage: %usage%",
                displayName = "Invalid Arguments",
                description = "Sent when the user gives invalid options."
        ),
        @I18nDefault(
                key = "invalid.subcommand",
                message = "%commander%, what do you want to do with a fact? Type !fact help for a list",
                displayName = "Invalid Command",
                description = "Sent when the user gives an invalid command."
        ),
        @I18nDefault(
                key = "noexist",
                message = "%commander%, fact \"%id%\" doesn't exist",
                displayName = "No Such Factoid",
                description = "Sent when the user attempts to modify a non-existent factoid."
        ),
        @I18nDefault(
                key = "alreadyexists",
                message = "%commander%, the fact \"%fact%\" already exists",
                displayName = "Factoid Already Exists",
                description = "Sent when the user attempts to create a factoid that already exists."
        ),
        @I18nDefault(
                key = "toomany.aliases",
                message = "%commander%, \"%alias%\" is an alias to an alias to an alias... And so on. Consider aliasing \"%alias%\" to a fact directly.",
                displayName = "Too Many Aliases",
                description = "Sent when the user attempts to alias a factoid to an alias."
        ),
        /* success */
        @I18nDefault(
                key = "add.success",
                message = "%commander%, \"%id%\" has been added as \"%fact%\"",
                displayName = "Add Success",
                description = "Sent when the user successfully adds a factoid."
        ),
        @I18nDefault(
                key = "alias.success",
                message = "%commander%, \"%id%\" is now aliased to \"%alias%\"",
                displayName = "Alias Success",
                description = "Sent when the user successfully creates a factoid."
        ),
        @I18nDefault(
                key = "setperm.success",
                message = "%commander%, \"%id%\" is now available only to those with %perm%",
                displayName = "Set Permission Success",
                description = "Sent when the user successfully restricts a factoid to a specific permission."
        ),
        @I18nDefault(
                key = "edit.success",
                message = "%commander%, \"%id%\" has been modified to say \"%fact%\"",
                displayName = "Edit Success",
                description = "Sent when the user successfully edits a factoid."
        ),
        @I18nDefault(
                key = "remove.fact.success",
                message = "%commander%, \"%id%\" has been deleted. It said: %fact%",
                displayName = "Remove Success",
                description = "Sent when the user successfully removes a factoid."
        ),
        @I18nDefault(
                key = "remove.alias.success",
                message = "%commander%, \"%id%\" is no longer aliased to \"%alias%\"",
                displayName = "Remove Alias Success",
                description = "Sent when the user successfully removes an alias."
        ),
        @I18nDefault(
                key = "list",
                message = "%commander%, here's a list of all the facts: %list%",
                displayName = "List Factoids",
                description = "Sent when the user lists all of the factoids."
        ),
        @I18nDefault(
                key = "list.nofacts",
                message = "%commander%, there are no facts set up... Add one with !fact add",
                displayName = "No Factoids",
                description = "Sent when the user lists factoids but none exist."
        ),
        @I18nDefault(
                key = "info.standard",
                message = "%commander%, \"%id%\" is %enabled%. It has the permission %perm%. It looks like this: %fact%",
                displayName = "Info (Permissions)",
                description = "Sent when the user gets info on the factoid, and the factoid is restricted by permissions."
        ),
        @I18nDefault(
                key = "info.noperm",
                message = "%commander%, \"%id%\" is %enabled%. It looks like this: %fact%",
                displayName = "Info (No Permissions)",
                description = "Sent when the user gets info on the factoid, and the factoid has no permission restrictions."
        ),
        @I18nDefault(
                key = "info.alias",
                message = "%commander%, \"%id%\" is an alias for \"%to%\"",
                displayName = "Info (Alias)",
                description = "Sent when the user gets info on the factoid, and the factoid is an alias."
        ),
        @I18nDefault(
                key = "toggle.success",
                message = "%commander%, \"%id%\" is now %status%",
                displayName = "Toggle Success",
                description = "Sent when the user successfully toggles the state of a factoid."
        )
})
public class FactoidsModule extends RegisteredThreadedModule<FactoidsGlobalConfiguration, FactoidsUserConfiguration> {
    public static final String CUSTOM_PREM_PREFIX = "factoids.use.";

    @Override
    public String getName() {
        return "factoids";
    }

    // Global command provider, for manipulating factoids
    private CommandDelegator delegator;
    private CommandDelegator customDelegators;

    public static void main(final String[] args) throws Exception {
        new FactoidsModule().entryPoint(args);
    }

    public void initialize() {
        super.initialize();
        delegator = new CommandDelegator("!");
        delegator.registerCommand(new FactCommand(this));
        customDelegators = new CommandDelegator(new FactoidCommandProvider(this), "!");
        registerListener(new FactoidsListener(this));
    }

    public void handleMessage(final ChatMessageEvent ev) {
        delegator.handleChatMessage(ev);
        customDelegators.handleChatMessage(ev);
    }

    public boolean isEnabled(final Channel channel) {
        return getConfiguration(channel).isEnabled();
    }

    /**
     * add a factoid
     * @param tenant
     * @param id
     * @param reply
     * @return
     */
    public Factoid addFact(final Tenant tenant, final String id, final String reply) {
        return addFact(tenant, id, reply, null);
    }

    /**
     * add a factoid with an optional permission
     * @param tenant
     * @param id
     * @param reply
     * @param permission
     * @return
     */
    public Factoid addFact(final Tenant tenant, final String id, final String reply, final Permission permission) {
        return addFact(tenant, id, reply, permission, false);
    }

    /**
     * Add a factoid or an alias with an optional permission
     * @param tenant tenant to add it to
     * @param id id of the fact or alias
     * @param data reply if fact, target if alias
     * @param permission permission required for the command; ignored if an alias
     * @param isAlias true if this is an alias
     * @return
     */
    public Factoid addFact(final Tenant tenant, final String id, final String data, final Permission permission, final boolean isAlias) {
        final tv.v1x1.common.dto.db.Permission dbPermission;
        if(permission == null) dbPermission = null;
        else dbPermission = new tv.v1x1.common.dto.db.Permission(permission.getNode());
        final Factoid fact = new Factoid(tenant, data, dbPermission, isAlias);
        return addFact(tenant, id, fact);
    }

    public Factoid addFact(final Tenant tenant, final String id, final Factoid fact) {
        final FactoidsUserConfiguration config = getConfiguration(tenant);
        config.add(id, fact);
        getUserConfigProvider().save(tenant, config);
        return fact;
    }

    public boolean hideFact(final Tenant tenant, final String id, final boolean hidden) {
        final FactoidsUserConfiguration config = getConfiguration(tenant);
        final Factoid fact = config.chaseDownById(id);
        if(fact == null)
            return false;
        fact.setHidden(hidden);
        getUserConfigProvider().save(tenant, config);
        return true;
    }

    /**
     * remove a factoid or alias
     * @param tenant
     * @param id
     * @return
     */
    public Factoid delFact(final Tenant tenant, final String id) {
        final FactoidsUserConfiguration config = getConfiguration(tenant);
        Factoid fact = config.del(id);
        if(fact != null) {
            getUserConfigProvider().save(tenant, config);
            pruneAliases(tenant, id);
        }
        return fact;
    }

    /**
     * return a factoid to spit out the fact or check permissions
     * @param tenant
     * @param id
     * @return
     */
    public Factoid getFact(final Tenant tenant, final String id) {
        return getConfiguration(tenant).chaseDownById(id);
    }

    /**
     * returns the factoid given, even if it's an alias
     * @param tenant
     * @param id
     * @return
     */
    public Factoid getFactDirectly(final Tenant tenant, final String id) {
        return getConfiguration(tenant).getById(id);
    }

    /**
     * get a list of all facts
     * @param tenant
     * @return all facts
     */
    public Set<Map.Entry<String,Factoid>> getFacts(final Tenant tenant) {
        return getConfiguration(tenant).all();
    }

    /**
     * Delete all aliases for a fact; usually called before deleting a fact
     * @param tenant
     * @param id
     */
    public void pruneAliases(final Tenant tenant, final String id) {
        final FactoidsUserConfiguration config = getConfiguration(tenant);
        for(Map.Entry<String,Factoid> fact : config.all()) {
            if(!fact.getValue().isAlias()) continue;
            if(fact.getValue().getData().equals(id)) delFact(tenant, fact.getKey());
        }
    }

    /**
     * Delete all aliases for all deleted facts; delete all aliases to aliases
     * @param tenant
     */
    public void pruneAliases(final Tenant tenant) {
        final FactoidsUserConfiguration config = getConfiguration(tenant);
        for(Map.Entry<String, Factoid> fact : config.all()) {
            if(fact.getValue().isAlias()) {
                final Factoid target = config.getById(fact.getValue().getData());
                if(target == null || target.isAlias())
                    delFact(tenant, fact.getKey());
            }
        }
    }

    /**
     * Delete all facts that have no message
     * @param tenant
     */
    public void pruneBlanks(final Tenant tenant) {
        final FactoidsUserConfiguration config = getConfiguration(tenant);
        for(Map.Entry<String, Factoid> fact : config.all()) {
            if(fact.getValue().getData() == null)
                delFact(tenant, fact.getKey());
        }
    }
}
