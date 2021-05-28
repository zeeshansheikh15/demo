package org.mongo.zee.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="records")
public class Record {

    String competition;
    int year;
    String team1;
    String team2;
    String team1goals;
    String team2goals;

    public java.lang.String getCompetition() {
        return competition;
    }

    public void setCompetition(java.lang.String competition) {
        this.competition = competition;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public java.lang.String getTeam1() {
        return team1;
    }

    public void setTeam1(java.lang.String team1) {
        this.team1 = team1;
    }

    public java.lang.String getTeam2() {
        return team2;
    }

    public void setTeam2(java.lang.String team2) {
        this.team2 = team2;
    }

    public java.lang.String getTeam1goals() {
        return team1goals;
    }

    public void setTeam1goals(java.lang.String team1goals) {
        this.team1goals = team1goals;
    }

    public java.lang.String getTeam2goals() {
        return team2goals;
    }

    public void setTeam2goals(java.lang.String team2goals) {
        this.team2goals = team2goals;
    }
}
