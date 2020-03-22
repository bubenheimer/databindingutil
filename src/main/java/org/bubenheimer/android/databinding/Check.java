/*
 * Copyright (c) 2015-2020 Uli Bubenheimer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.bubenheimer.android.databinding;

import android.os.Handler;
import android.os.Looper;

import org.bubenheimer.util.Uninstantiable;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;

@SuppressWarnings("WeakerAccess")
public final class Check extends Uninstantiable {
    public static void notNull(final Object obj) {
        if (obj == null) {
            throw new AssertionError();
        }
    }

    public static void isNull(final Object obj) {
        if (obj != null) {
            throw new AssertionError();
        }
    }

    public static void equals(final int expected, final int actual) {
        if (expected != actual) {
            throw new AssertionError();
        }
    }

    public static void equals(final long expected, final long actual) {
        if (expected != actual) {
            throw new AssertionError();
        }
    }

    @SuppressWarnings("unused")
    public static void equals(final short expected, final short actual) {
        if (expected != actual) {
            throw new AssertionError();
        }
    }

    @SuppressWarnings("unused")
    public static void equals(final byte expected, final byte actual) {
        if (expected != actual) {
            throw new AssertionError();
        }
    }

    @SuppressWarnings("unused")
    public static void equals(final char expected, final char actual) {
        if (expected != actual) {
            throw new AssertionError();
        }
    }

    public static void equals(final Object expected, final Object actual) {
        if (!ObjectsCompat.equals(expected, actual)) {
            throw new AssertionError(
                    "Objects not equal -  expected: " + expected + "  actual: " + actual);
        }
    }

    public static void notEquals(final int expected, final int actual) {
        if (expected == actual) {
            throw new AssertionError();
        }
    }

    @SuppressWarnings("unused")
    public static void notEquals(final long expected, final long actual) {
        if (expected == actual) {
            throw new AssertionError();
        }
    }

    @SuppressWarnings("unused")
    public static void notEquals(final short expected, final short actual) {
        if (expected == actual) {
            throw new AssertionError();
        }
    }

    @SuppressWarnings("unused")
    public static void notEquals(final byte expected, final byte actual) {
        if (expected == actual) {
            throw new AssertionError();
        }
    }

    @SuppressWarnings("unused")
    public static void notEquals(final char expected, final char actual) {
        if (expected == actual) {
            throw new AssertionError();
        }
    }

    public static void notEquals(final Object expected, final Object actual) {
        if (ObjectsCompat.equals(expected, actual)) {
            throw new AssertionError();
        }
    }

    @SuppressWarnings("unused")
    public static void same(final Object expected, final Object actual) {
        if (expected != actual) {
            throw new AssertionError(
                    "Objects not the same -  expected: " + expected + "  actual: " + actual);
        }
    }

    @SuppressWarnings("unused")
    public static void notSame(final Object expected, final Object actual) {
        if (expected == actual) {
            throw new AssertionError();
        }
    }

    public static void lessThan(final int value1, final int value2) {
        if (value1 >= value2) {
            throw new AssertionError();
        }
    }

    public static void lessOrEqual(final int value1, final int value2) {
        if (value1 > value2) {
            throw new AssertionError();
        }
    }

    public static void inRangeInclusive(final int value1, final int value2, final int value3) {
        if (value1 > value2 || value2 > value3) {
            throw new AssertionError();
        }
    }

    @SuppressWarnings("unused")
    public static void inRangeExclusive(final int value1, final int value2, final int value3) {
        if (value1 >= value2 || value2 >= value3) {
            throw new AssertionError();
        }
    }

    public static void lessThan(final long value1, final long value2) {
        if (value1 >= value2) {
            throw new AssertionError();
        }
    }

    public static void lessOrEqual(final long value1, final long value2) {
        if (value1 > value2) {
            throw new AssertionError();
        }
    }

    public static void inRangeInclusive(final long value1, final long value2, final long value3) {
        if (value1 > value2 || value2 > value3) {
            throw new AssertionError();
        }
    }

    @SuppressWarnings("unused")
    public static void inRangeExclusive(final long value1, final long value2, final long value3) {
        if (value1 >= value2 || value2 >= value3) {
            throw new AssertionError();
        }
    }

    public static void isOneOf(
            final int value,
            final int... set) {
        for (final int setValue : set) {
            if (value == setValue) {
                return;
            }
        }
        throw new AssertionError();
    }

    @SuppressWarnings("unused")
    public static void notOneOf(
            final int value,
            final int... set) {
        for (final int setValue : set) {
            if (value == setValue) {
                throw new AssertionError();
            }
        }
    }

    @SuppressWarnings("unused")
    public static void isOneOf(
            final long value,
            final long... set) {
        for (final long setValue : set) {
            if (value == setValue) {
                return;
            }
        }
        throw new AssertionError();
    }

    @SuppressWarnings("unused")
    public static void notOneOf(
            final long value,
            final long... set) {
        for (final long setValue : set) {
            if (value == setValue) {
                throw new AssertionError();
            }
        }
    }

    public static void isOneOfObjects(
            final @Nullable Object value,
            final @NonNull Object... set) {
        for (final Object setValue : set) {
            if (Objects.equals(value, setValue)) {
                return;
            }
        }
        throw new AssertionError();
    }

    @SuppressWarnings("unused")
    public static void notOneOfObjects(
            final @Nullable Object value,
            final @NonNull Object... set) {
        for (final Object setValue : set) {
            if (Objects.equals(value, setValue)) {
                throw new AssertionError();
            }
        }
    }

    public static void isTrue(final boolean value) {
        isTrue("", value);
    }

    public static void isTrue(final String message, final boolean value) {
        if (!value) {
            throw new AssertionError(message);
        }
    }

    public static void isFalse(final boolean value) {
        isFalse("", value);
    }

    public static void isFalse(final String message, final boolean value) {
        if (value) {
            throw new AssertionError(message);
        }
    }

    public static void fail(
            final Runnable runnable) {
        //noinspection CatchMayIgnoreException
        try {
            runnable.run();
        } catch (final Throwable e) {
        }
    }

    @SuppressWarnings("CaughtExceptionImmediatelyRethrown")
    public static void nofail(
            final Runnable runnable) {
        try {
            runnable.run();
        } catch (final Error | RuntimeException e) {
            throw e;
        }
    }

    @SuppressWarnings("unused")
    public static void fail() {
        throw new AssertionError();
    }

    public static void onThread(final Thread thread) {
        if (thread != Thread.currentThread()) {
            throw new AssertionError();
        }
    }

    public static void offThread(final Thread thread) {
        if (thread == Thread.currentThread()) {
            throw new AssertionError();
        }
    }

    public static void onLooperThread(final Looper looper) {
        onThread(looper.getThread());
    }

    public static void offLooperThread(final Looper looper) {
        offThread(looper.getThread());
    }

    public static void onHandlerThread(final Handler handler) {
        onLooperThread(handler.getLooper());
    }

    @SuppressWarnings("unused")
    public static void offHandlerThread(final Handler handler) {
        offLooperThread(handler.getLooper());
    }

    public static void onMainThread() {
        onLooperThread(Looper.getMainLooper());
    }

    public static void onWorkerThread() {
        offLooperThread(Looper.getMainLooper());
    }
}
