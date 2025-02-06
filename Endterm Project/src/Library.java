import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void addBook(Book book) {
        // Логика добавления книги в библиотеку (например, сохранение в базе данных)
        notifyObservers();
    }
}

