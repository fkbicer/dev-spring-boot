package com.example.cruddemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

    // annotate the calss as an entity and map to db table

    // define the fields

    // annotate the fileds with db column names

    // create constructors

    // generate getter/setter methods

    // generate toSring() method.
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="youtube_channel")
    private String youtubeChannel;

    @Column(name="hobby")
    private String hooby;

    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor instructor;

    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChannel, String hooby) {
        this.youtubeChannel = youtubeChannel;
        this.hooby = hooby;
    }

    public int getId() {
        return id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public String getHooby() {
        return hooby;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public void setHooby(String hooby) {
        this.hooby = hooby;
    }

      public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }


    @Override
    public String toString() {
        return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hooby=" + hooby + "]";
    }

  

    


}
