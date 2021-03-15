package com.quarkusredissontester;

import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.config.MeterFilter;
import io.quarkus.arc.Unremovable;

import javax.inject.Singleton;
import java.util.Arrays;

/**
 * Doesn't work, why?
 * From https://quarkus.io/guides/micrometer
 */
@Singleton
public class MetricsConfiguration {

    @Singleton
    @Unremovable
    public MeterFilter configureAllRegistries() {
        return MeterFilter.commonTags(Arrays.asList(
                Tag.of("application", "quarkus-lettuce-tester")));
    }
}
