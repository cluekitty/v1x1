import {Component, Input} from "@angular/core";
import {V1x1ConfigurationDefinitionField} from "../../../model/v1x1_configuration_definition_field";
import {ConfigurableComponent} from "../configurable";
@Component({
  selector: 'configuration-field-value-bot-name',
  template: `bot-name`
})
export class ConfigurationFieldValueBotNameComponent extends ConfigurableComponent {
  @Input() public field: V1x1ConfigurationDefinitionField;
}
