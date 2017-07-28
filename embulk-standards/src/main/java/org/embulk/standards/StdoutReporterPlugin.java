package org.embulk.standards;

import org.embulk.config.ConfigSource;
import org.embulk.config.Task;
import org.embulk.config.TaskSource;
import org.embulk.spi.ReporterCloseable;
import org.embulk.spi.ReporterPlugin;
import org.embulk.spi.util.AbstractReporter;
import org.embulk.spi.util.Reporters;

import javax.annotation.concurrent.ThreadSafe;

import java.util.Map;

public class StdoutReporterPlugin
        implements ReporterPlugin
{
    @Override
    public TaskSource configureTaskSource(final ConfigSource config)
    {
        return config.loadConfig(Task.class).dump();
    }

    @Override
    public ReporterCloseable open(final TaskSource task)
    {
        return new StdoutReporter();
    }

    @ThreadSafe
    private static class StdoutReporter
            extends AbstractReporter
    {
        @Override
        public void report(Reporters.ReportLevel level, Map<String, Object> event)
        {
            // FIXME TODO
            System.out.println("StdoutReport#report");
            System.out.println(event);
        }

        @Override
        public void close()
        {
            // FIXME TODO
            System.out.println("StdoutReport#close");
        }

        @Override
        public void cleanup()
        {
            // FIXME TODO
            System.out.println("StdoutReport#cleanup");
        }
    }
}