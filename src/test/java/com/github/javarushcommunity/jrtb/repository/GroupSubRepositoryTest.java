package com.github.javarushcommunity.jrtb.repository;

import com.github.javarushcommunity.jrtb.repository.entity.GroupSub;
import com.github.javarushcommunity.jrtb.repository.entity.TelegramUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class GroupSubRepositoryTest {
    private TelegramUserRepository telegramUserRepository;
    @Sql(scripts = {"/sql/clearDbr.sql", "/sql/fiveGroupSubForUser.sql"})
    @Test
    void shouldProperlyGetAllGroupSubForUser() {
        Optional<TelegramUser> userFromDB = telegramUserRepository.findById("1");
        Assertions.assertTrue(userFromDB.isPresent());
        List<GroupSub> groupSubList = userFromDB.get().getGroupSubs();
        for (int i = 0; i < groupSubList.size(); i++) {
            Assertions.assertEquals(String.format("g%s", (i + 1)), groupSubList.get(i).getTitle());
            Assertions.assertEquals(i + 1, groupSubList.get(i).getId());
            Assertions.assertEquals(i + 1, groupSubList.get(i).getLastArticleId());
        }
    }
}