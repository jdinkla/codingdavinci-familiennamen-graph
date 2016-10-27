/**
 * (c) 2016, Jörn Dinkla, http://www.dinkla.net
 *
 * see the file LICENSE in the root directory
 */
package net.dinkla.utils

import java.time.Instant

class Timer {

    final long totalWork;
    final long startTime
    long currentWork;

    public Timer(final long totalWork) {
        this.totalWork = totalWork
        this.currentWork = 0L
        startTime = Instant.now().toEpochMilli()
    }

    public double getPercentageWorkDone() {
        ((1.0 * currentWork) / totalWork) * 100
    }

    public long getDurationInMs() {
        final long now = Instant.now().toEpochMilli()
        final long ms = now - startTime;
        return ms
    }

    public Instant estimate() {
        final double workDone = (1.0 * currentWork) / totalWork
        final double sec = getDurationInMs() / 1000.0
        final double allTimeSec = ((1.0 / workDone) * sec)
        final double restTimeSec = allTimeSec - workDone
        final long restTimeMs = 1000 * restTimeSec.toLong()
        final long now = Instant.now().toEpochMilli()
        final Instant inst = Instant.ofEpochMilli(now + restTimeMs);
        return inst;
    }

    public String getMsg() {
        "Work done ${percentageWorkDone}, time ${Instant.now()}, estimated finish time ${estimate()}"
    }

    synchronized void setCurrentWork(final long currentWork) {
        this.currentWork = currentWork
    }

}
