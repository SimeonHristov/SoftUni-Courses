package _06_SOLID_WORKSHOP.logger.model.layouts;

import _06_SOLID_WORKSHOP.logger.api.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String getLayout() {
        return "%s - %s - %s";
    }
}