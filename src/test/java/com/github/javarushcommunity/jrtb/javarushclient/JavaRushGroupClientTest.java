package com.github.javarushcommunity.jrtb.javarushclient;

import com.github.javarushcommunity.jrtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.javarushcommunity.jrtb.javarushclient.dto.GroupInfo;
import com.github.javarushcommunity.jrtb.javarushclient.dto.GroupRequestArgs;
import com.github.javarushcommunity.jrtb.javarushclient.dto.GroupsCountRequestArgs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static com.github.javarushcommunity.jrtb.javarushclient.dto.GroupInfoType.TECH;

@DisplayName("Integration-leve testing for JavaRushGroupClientImplTest")
class JavaRushGroupClientTest {

    private final JavaRushGroupClient groupClient = new JavaRushGroupClientImpl("https://javarush.ru/api/1.0/rest");

    @Test
    public void shouldProperlyGetGroupsWithEmptyArgs() {
        GroupRequestArgs args = GroupRequestArgs.builder().build();
        List<GroupInfo> groupList = groupClient.getGroupList(args);
        Assertions.assertNotNull(groupList);
        Assertions.assertFalse(groupList.isEmpty());
    }

    @Test
    void shouldProperlyGetWithOffSetAndLimit() {
        GroupRequestArgs args = GroupRequestArgs.builder()
                .offset(1)
                .limit(3)
                .build();
        List<GroupInfo> groupList = groupClient.getGroupList(args);
        Assertions.assertNotNull(groupList);
        Assertions.assertEquals(3, groupList.size());
    }

    @Test
    void shouldProperlyGetGroupsDiscWithEmptyArgs() {
        GroupRequestArgs args = GroupRequestArgs.builder().build();
        List<GroupDiscussionInfo> groupList = groupClient.getGroupDiscussionList(args);
        Assertions.assertNotNull(groupList);
        Assertions.assertFalse(groupList.isEmpty());
    }

    @Test
    void shouldProperlyGetGroupDiscWithOffSetAndLimit() {
        GroupRequestArgs args = GroupRequestArgs.builder()
                .offset(1)
                .limit(3)
                .build();
        List<GroupDiscussionInfo> groupList = groupClient.getGroupDiscussionList(args);
        Assertions.assertNotNull(groupList);
        Assertions.assertEquals(3, groupList.size());
    }

    @Test
    void shouldProperlyGetGroupCount() {
        GroupsCountRequestArgs args = GroupsCountRequestArgs.builder().build();
        Integer groupCount = groupClient.getGroupCount(args);
        Assertions.assertEquals(30, groupCount);
    }

    @Test
    void shouldProperlyGetGroupTECHCount() {
        GroupsCountRequestArgs args = GroupsCountRequestArgs.builder()
                .type(TECH)
                .build();
        Integer groupCount = groupClient.getGroupCount(args);
        Assertions.assertEquals(7, groupCount);
    }

    @Test
    void shouldProperlyGetGroupById() {
        Integer androidGroupId = 16;
        GroupDiscussionInfo groupById = groupClient.getGroupById(androidGroupId);
        Assertions.assertNotNull(groupById);
        Assertions.assertEquals(16, groupById.getId());
        Assertions.assertEquals(TECH, groupById.getType());
        Assertions.assertEquals("android", groupById.getKey());
    }
}