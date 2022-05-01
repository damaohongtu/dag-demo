package com.mao.dag.util;

import com.google.common.collect.Maps;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.Map;
import java.util.concurrent.*;

public class EventBusManager {

    private EventBusManager(){}

    private static final Map<String, EventBus> EVENT_BUS_MAP = Maps.newConcurrentMap();

    private  static BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(50);

    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 100,
            60*3L, TimeUnit.SECONDS, workQueue);

    private static final Map<String, EventBus> ASYNC_EVENT_BUS_MAP = Maps.newConcurrentMap();

    public static EventBus getEventBus(String eventType){
        return EVENT_BUS_MAP.computeIfAbsent(eventType, k-> new EventBus());
    }

    public static EventBus getAsyncEventBus (String eventType, Executor executor){
        return ASYNC_EVENT_BUS_MAP.computeIfAbsent(eventType, k-> new AsyncEventBus(executor));
    }

}
