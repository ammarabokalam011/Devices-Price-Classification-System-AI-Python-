package com.ammar.devicespriceclassificationsystem.model;

import com.ammar.devicespriceclassificationsystem.PriceRange;
import com.opencsv.bean.CsvBindByName;

public class Device {
    @CsvBindByName(column = "id")
    int id;
    @CsvBindByName(column = "battery_power")
    int battery_power;
    @CsvBindByName(column = "blue")
    int blue;
    @CsvBindByName(column = "clock_speed")
    double clock_speed;

    public int getId() {
        return id;
    }

    public int getBattery_power() {
        return battery_power;
    }

    public int getBlue() {
        return blue;
    }

    public double getClock_speed() {
        return clock_speed;
    }

    public boolean isDual_sim() {
        return dual_sim;
    }

    public int getFc() {
        return fc;
    }

    public boolean isFour_g() {
        return four_g;
    }

    public int getInt_memory() {
        return int_memory;
    }

    public double getM_dep() {
        return m_dep;
    }

    public int getMobile_wt() {
        return mobile_wt;
    }

    public int getN_cores() {
        return n_cores;
    }

    public int getPc() {
        return pc;
    }

    public int getPx_height() {
        return px_height;
    }

    public int getPx_width() {
        return px_width;
    }

    public int getRam() {
        return ram;
    }

    public int getSc_h() {
        return sc_h;
    }

    public int getSc_w() {
        return sc_w;
    }

    public int getTalk_time() {
        return talk_time;
    }

    public boolean isThree_g() {
        return three_g;
    }

    public boolean isTouch_screen() {
        return touch_screen;
    }

    public boolean isWifi() {
        return wifi;
    }

    public PriceRange getPrice_range() {
        return price_range;
    }

    @CsvBindByName(column = "dual_sim")
    boolean dual_sim;
    @CsvBindByName(column = "fc")
    int fc;
    @CsvBindByName(column = "four_g")
    boolean four_g;
    @CsvBindByName(column = "int_memory")
    int int_memory;
    @CsvBindByName(column = "m_dep")
    double m_dep;
    @CsvBindByName(column = "mobile_wt")
    int mobile_wt;
    @CsvBindByName(column = "n_cores")
    int n_cores;
    @CsvBindByName(column = "pc")
    int pc;
    @CsvBindByName(column = "px_height")
    int px_height;
    @CsvBindByName(column = "px_width")
    int px_width;
    @CsvBindByName(column = "ram")
    int ram;
    @CsvBindByName(column = "sc_h")
    int sc_h;
    @CsvBindByName(column = "sc_w")
    int sc_w;
    @CsvBindByName(column = "talk_time")
    int talk_time;
    @CsvBindByName(column = "three_g")
    boolean three_g;
    @CsvBindByName(column = "touch_screen")
    boolean touch_screen;
    @CsvBindByName(column = "wifi")
    boolean wifi;
    @CsvBindByName(column = "price_range")
    PriceRange price_range;


    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", battery_power=" + battery_power +
                ", blue=" + blue +
                ", clock_speed=" + clock_speed +
                ", dual_sim=" + dual_sim +
                ", fc=" + fc +
                ", four_g=" + four_g +
                ", int_memory=" + int_memory +
                ", m_dep=" + m_dep +
                ", mobile_wt=" + mobile_wt +
                ", n_cores=" + n_cores +
                ", pc=" + pc +
                ", px_height=" + px_height +
                ", px_width=" + px_width +
                ", ram=" + ram +
                ", sc_h=" + sc_h +
                ", sc_w=" + sc_w +
                ", talk_time=" + talk_time +
                ", three_g=" + three_g +
                ", touch_screen=" + touch_screen +
                ", wifi=" + wifi +
                ", price_range=" + price_range +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBattery_power(int battery_power) {
        this.battery_power = battery_power;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public void setClock_speed(double clock_speed) {
        this.clock_speed = clock_speed;
    }

    public void setDual_sim(boolean dual_sim) {
        this.dual_sim = dual_sim;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }

    public void setFour_g(boolean four_g) {
        this.four_g = four_g;
    }

    public void setInt_memory(int int_memory) {
        this.int_memory = int_memory;
    }

    public void setM_dep(double m_dep) {
        this.m_dep = m_dep;
    }

    public void setMobile_wt(int mobile_wt) {
        this.mobile_wt = mobile_wt;
    }

    public void setN_cores(int n_cores) {
        this.n_cores = n_cores;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public void setPx_height(int px_height) {
        this.px_height = px_height;
    }

    public void setPx_width(int px_width) {
        this.px_width = px_width;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setSc_h(int sc_h) {
        this.sc_h = sc_h;
    }

    public void setSc_w(int sc_w) {
        this.sc_w = sc_w;
    }

    public void setTalk_time(int talk_time) {
        this.talk_time = talk_time;
    }

    public void setThree_g(boolean three_g) {
        this.three_g = three_g;
    }

    public void setTouch_screen(boolean touch_screen) {
        this.touch_screen = touch_screen;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public void setPrice_range(PriceRange price_range) {
        this.price_range = price_range;
    }
}
