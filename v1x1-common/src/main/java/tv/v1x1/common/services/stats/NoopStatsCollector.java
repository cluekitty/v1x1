package tv.v1x1.common.services.stats;

import com.google.inject.Singleton;

/**
 * Created by cobi on 10/12/2016.
 */
@Singleton
public class NoopStatsCollector implements StatsCollector {

    @Override
    public void track(final Throwable throwable) {
        //TODO: Stub.
    }

    @Override
    public void event(final String eventName) {
        //TODO: Stub.
    }

    @Override
    public void timedEvent(final String eventName, final long timeMs) {
        //TODO: Stub.
    }

    @Override
    public void timedEvent(final String eventName, final Runnable runnable) {
        //TODO: Stub.
        runnable.run();
    }

    @Override
    public void set(final String stat, final long value) {
        //TODO: Stub.
    }
}
