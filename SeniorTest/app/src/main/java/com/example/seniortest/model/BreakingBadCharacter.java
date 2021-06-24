package com.example.seniortest.model;

import java.io.Serializable;
import java.util.List;

public class BreakingBadCharacter implements Serializable {
    public int char_id;
    public String name;
    public String birthday;
    public List<String> occupation;
    public String img;
    public String status;
    public String nickname;
    public List<Integer> appearance;
    public String portrayed;
    public String category;
    public List<Object> better_call_saul_appearance;

    public BreakingBadCharacter() {
    }

    public int getChar_id() {
        return char_id;
    }

    public void setChar_id(int char_id) {
        this.char_id = char_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(List<String> occupation) {
        this.occupation = occupation;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Integer> getAppearance() {
        return appearance;
    }

    public void setAppearance(List<Integer> appearance) {
        this.appearance = appearance;
    }

    public String getPortrayed() {
        return portrayed;
    }

    public void setPortrayed(String portrayed) {
        this.portrayed = portrayed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Object> getBetter_call_saul_appearance() {
        return better_call_saul_appearance;
    }

    public void setBetter_call_saul_appearance(List<Object> better_call_saul_appearance) {
        this.better_call_saul_appearance = better_call_saul_appearance;
    }

    @Override
    public String toString() {
        return "Character{" +
                "char_id=" + char_id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", occupation=" + occupation +
                ", img='" + img + '\'' +
                ", status='" + status + '\'' +
                ", nickname='" + nickname + '\'' +
                ", appearance=" + appearance +
                ", portrayed='" + portrayed + '\'' +
                ", category='" + category + '\'' +
                ", better_call_saul_appearance=" + better_call_saul_appearance +
                '}';
    }
}
