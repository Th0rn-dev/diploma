package com.github.Th0rn_dev.restaurants_voting.util;


import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.time.Clock;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;


@Slf4j
@UtilityClass
public final class ClockUtil {
    private static final AtomicReference<Clock> CLOCK_REFERENCE = new AtomicReference<>(Clock.systemDefaultZone());

    @NonNull
    public static Clock getClock() {
        return CLOCK_REFERENCE.get();
    }

    @NonNull
    public static Clock setClock(@NonNull final Clock newClock) {
        Objects.requireNonNull(newClock, "newClock cannot be null");
        final Clock oldClock = CLOCK_REFERENCE.getAndSet(newClock);
        log.info("Set new clock {}. OldClock is {}", newClock, oldClock);
        return oldClock;
    }
}
