package ru.job4j.departmentsorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartmentSortingTest {
    @Test
    public void upToDownFirstTest(){
        //Set<String> upToDownSort(List<String> departments)
        List<String> test = new ArrayList<>(Arrays.asList(
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2\\SSSK1"));

        DepartmentSorting departmentSorting = new DepartmentSorting();
        Set<String> result =  departmentSorting.upToDownSort(test);
        List<String> expected = new ArrayList<>(Arrays.asList(
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK2\\SSSK1"));
        assertThat(result,is(expected));
    }



}
