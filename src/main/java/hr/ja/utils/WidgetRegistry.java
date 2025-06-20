package hr.ja.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WidgetRegistry {
    private static final Map<String, WidgetLocation> map = new ConcurrentHashMap<>();

    public static void register(String widgetId, WidgetLocation loc) {
        map.put(widgetId, loc);
    }

    public static WidgetLocation getLocation(String widgetId) {
        return map.get(widgetId);
    }
}