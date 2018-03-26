package ru.job4j.departmentsorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * DepartmentSortingTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class DepartmentSortingTest {
    /**
     * The First test.
     */
    @Test
    public void upToDownTest() {
        List<String> test = new ArrayList<>(Arrays.asList(
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2\\SSSK1"));

        DepartmentSorting departmentSorting = new DepartmentSorting();
        CompareDepartmentsUp cdu = new CompareDepartmentsUp();
        ArrayList<String> result = new ArrayList<>(departmentSorting.sort(test, cdu));
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
        assertThat(result, is(expected));
    }

    /**
     * The Second test.
     */
    @Test
    public void downToUpTest() {
        List<String> test = new ArrayList<>(Arrays.asList(
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"));

        DepartmentSorting departmentSorting = new DepartmentSorting();
        CompareDepartmentsDown cpd = new CompareDepartmentsDown();
        ArrayList<String> result = new ArrayList<>(departmentSorting.sort(test, cpd));
        List<String> expected = new ArrayList<>(Arrays.asList(
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        ));
        assertThat(result, is(expected));
    }
}
