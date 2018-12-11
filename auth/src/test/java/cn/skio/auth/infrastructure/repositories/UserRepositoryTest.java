package cn.skio.auth.infrastructure.repositories;

import cn.skio.auth.domain.User;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {

  @Before
  public void setUp() throws Exception {
    Operation operation = Operations.sequenceOf(
        Operations.deleteAllFrom("user"),
        Operations.insertInto("user")
            .columns("id", "username", "password", "salt", "created_at", "updated_at")
            .values(1, "test", "123", "salt", new Date(), new Date())
            .build());

    DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation);
    dbSetupTracker.launchIfNecessary(dbSetup);
  }

  @Test
  public void findByUsername() {

    User user = userRepository.findByUsername("test");
    assertThat(user.getUsername()).isEqualTo("test");
  }

  private static DbSetupTracker dbSetupTracker = new DbSetupTracker();
  @Resource
  private DataSource dataSource;

  @Autowired
  private UserRepository userRepository;
}