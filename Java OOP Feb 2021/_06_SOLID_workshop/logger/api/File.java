package _06_SOLID_WORKSHOP.logger.api;

public interface File {
    int getSize();

    void write(String message);
}