package vip.xjdai.annotation.DependsOn.demo2;

import org.springframework.context.annotation.Description;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 监听器管理类
 */
@Description("")
public class EventManager {
    private final List<Consumer<String>> listeners = new ArrayList<>();

    private EventManager() {
    }

    private static class SingletonHolder {
        private static final EventManager INSTANCE = new EventManager();
    }

    public static EventManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void publish(final String message) {
        listeners.forEach(l -> l.accept(message));
    }

    public void addListener(Consumer<String> eventConsumer) {
        listeners.add(eventConsumer);
    }
}