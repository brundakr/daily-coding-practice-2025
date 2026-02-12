package org.example.week2.day11.morning;


import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class NewsAgency {
    private String news;
    private List<Observer> observers = new ArrayList<>();

    public void  addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    private void notifyObservers() {
        observers.forEach(observer -> observer.update(news)); //calls update methods of emailsubs and sms subs
    }


}

class EmailSubscriber implements Observer {
    private String subscriberName;

    public EmailSubscriber(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    @Override
    public void update(String news) {
        System.out.println(subscriberName + " received mail: " + news);
    }
}

class SmsSubscriber implements Observer {
    private String subscriberName;

    public SmsSubscriber(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    @Override
    public void update(String news) {
        System.out.println(subscriberName + " received sms: " + news);
    }
}


public class ObserverPattern {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        EmailSubscriber emailSubscriber = new EmailSubscriber("John");
        SmsSubscriber smsSubscriber = new SmsSubscriber("Kelly");

        newsAgency.addObserver(emailSubscriber);
        newsAgency.addObserver(smsSubscriber);

        newsAgency.setNews("Government of India ...blah blah blah");

    }
}
