package com.dump.todoList.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class TodoItem implements Serializable {

    @Id
    private Long id;
    private String title;
    private Boolean done;

    public TodoItem() {
    }

    public TodoItem(Long id, String title, Boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", done='" + done + '\'' +
                '}';
    }
}
