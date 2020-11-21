package shimizu.starter.clear.backupdata;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import shimizu.common.exception.BusinessException;

import javax.management.timer.Timer;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自动备份数据
 *
 * @author Shimizu
 * @version 1.0
 * @date 2020/8/5 13:46
 */
@Component
@AllArgsConstructor
@Profile(value = {"dev"})
public class BackUpDataSchedule {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Environment environment;
    private final String OS_NAME = "os.name";
    private final String LINUX_OS_NAME = "Linux";

    @Async
    @Scheduled(initialDelay = Timer.ONE_MINUTE, fixedRate = Timer.ONE_HOUR * 2)
    public void backUpDataSchedule() {
        logger.info("Start Back UpData Schedule: " + LocalDate.now().toString() + " " + LocalTime.now());
        //创建储存的文件夹
        File file = new File(System.getProperty("user.dir") + "/sql");
        if (!file.exists()) {
            file.mkdir();
        }
        Runtime runtime = Runtime.getRuntime();
        //获取数据库的名字
        String schema = getSchema();
        //时间
        String time = LocalDate.now() + "-" + LocalTime.now().getHour() + "-" + LocalTime.now().getMinute();
        //获得未处理的地址
        String location = System.getProperty("user.dir") + "/sql/" + time + "-" + schema + ".sql";
        location = location.replaceAll("\\\\", "/");
        final String[] dumpCommand;
        String command = String.format("mysqldump --default-character-set=utf8 -uroot -proot %s --hex-blob > %s", schema, location);
        //判断是在Linux系统环境下 还是windows系统环境下
        if (!LINUX_OS_NAME.equals(System.getProperty(OS_NAME))) {
            dumpCommand = new String[]{
                    "cmd", "/c", command
            };

        } else {
            dumpCommand = new String[]{
                    "/bin/sh", "-c", command
            };
        }

        try {
            //此处执行的是ipconfig命令，可以换成任何cmd or /bin/sh里的命令。
            runtime.exec(dumpCommand);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info(String.format("备份的数据库名称为:[%s] 备份位置为:[%s]", schema, location));
        logger.info("End Back UpData Schedule: " + LocalDate.now().toString() + " " + LocalTime.now());
    }

    /**
     * 获取数据库的名字
     *
     * @return
     */
    public String getSchema() {
        final String regx = "[a-zA-Z0-9_]+\\?";
        Matcher matcher = Pattern.compile(regx).matcher(Objects.requireNonNull(environment.getProperty("spring.datasource.url")));
        if (matcher.find()) {
            return matcher.group().substring(0, matcher.group().length() - 1);
        } else {
            throw new BusinessException("数据库不存在 请检查配置文件");
        }
    }
}
