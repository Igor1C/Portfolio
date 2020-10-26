package com.igor1c.portfolio.helpers;

import com.igor1c.portfolio.dto.helpers.Selectable;

import java.util.ArrayList;
import java.util.List;

public class CollectionsHelper {

    public static boolean listsHaveCrossing(List list1, List list2) {
        for (Object item1 : list1) {
            for (Object item2 : list2) {
                if (item1.equals(item2)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static List<Long> getSelectedIdList(List<? extends Selectable> list) {
        List<Long> idList = new ArrayList<>();
        list.stream().filter(entity -> entity.isSelected()).forEach(e -> idList.add(e.getId()));
        return idList;
    }
}
