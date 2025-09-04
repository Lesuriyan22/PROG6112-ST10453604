/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package streamingtest;

import org.junit.Test;
import static org.junit.Assert.*;
import Streaming.*;

public class SeriesTests {

    private Series seeded() {
        Series s = new Series();
        s.addSeriesModel(new SeriesModel("101", "Extreme Sports", "12", "10"));
        return s;
    }

    @Test
    public void TestSearchSeries() {
        Series s = seeded();
        SeriesModel m = s.findById("101");
        assertNotNull(m);
        assertEquals("Extreme Sports", m.SeriesName);
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        Series s = seeded();
        assertNull(s.findById("999"));
    }

    @Test
    public void TestUpdateSeries() {
        Series s = seeded();
        SeriesModel m = s.findById("101");
        m.SeriesName = "Extreme Sports 2025";
        assertEquals("Extreme Sports 2025", s.findById("101").SeriesName);
    }

    @Test
    public void TestDeleteSeries() {
        Series s = seeded();
        SeriesModel m = s.findById("101");
        assertNotNull(m);
        s.deleteById("101");
        assertNull(s.findById("101"));
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        Series s = seeded();
        assertNull(s.findById("555"));
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        Series s = new Series();
        assertTrue(s.isNumeric("10"));
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInvalid() {
        Series s = new Series();
        assertFalse(s.isNumeric("Ten"));
    }
}