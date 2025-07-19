package com.lsxp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGroup {

    /*用户ID*/
    private int userId;

    /*群组ID*/
    private int groupId;

    private List<User> users;

    private List<GroupList> groupList;
}

