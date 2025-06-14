package com.amberclient.events;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private static final EventManager INSTANCE = new EventManager(); // Singleton instance
    private final List<PreMotionListener> preMotionListeners = new ArrayList<>();
    private final List<PostMotionListener> postMotionListeners = new ArrayList<>();

    // Private constructor to prevent external instantiation
    public EventManager() {
    }

    // Public method to access the singleton instance
    public static EventManager getInstance() {
        return INSTANCE;
    }

    public void add(Class<?> type, Object listener) {
        if (type == PreMotionListener.class && listener instanceof PreMotionListener) {
            preMotionListeners.add((PreMotionListener) listener);
        } else if (type == PostMotionListener.class && listener instanceof PostMotionListener) {
            postMotionListeners.add((PostMotionListener) listener);
        }
    }

    public void remove(Class<?> type, Object listener) {
        if (type == PreMotionListener.class) {
            preMotionListeners.remove(listener);
        } else if (type == PostMotionListener.class) {
            postMotionListeners.remove(listener);
        }
    }

    public void firePreMotion() {
        for (PreMotionListener listener : new ArrayList<>(preMotionListeners)) {
            listener.onPreMotion();
        }
    }

    public void firePostMotion() {
        for (PostMotionListener listener : new ArrayList<>(postMotionListeners)) {
            listener.onPostMotion();
        }
    }
}