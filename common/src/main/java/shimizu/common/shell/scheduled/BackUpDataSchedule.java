//package shimizu.common.shell.scheduled;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.env.Environment;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import shimizu.common.exception.BusinessException;
//
//import javax.management.timer.Timer;
//import javax.swing.*;
//import java.io.*;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.Calendar;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * 自动备份数据
// *
// * @author Shimizu
// * @version 1.0
// * @date 2020/8/5 13:46
// */
//@Component
//@AllArgsConstructor
//@Slf4j
//public class BackUpDataSchedule {
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    private final Environment environment;
//
//    @Async
//    @Scheduled(initialDelay = Timer.ONE_SECOND * 10, fixedRate = Timer.ONE_HOUR * 2)
//    public void backUpDataSchedule() {
//        logger.info("back UpData Schedule" + Calendar.getInstance().getTime());
//        //创建储存的文件夹
//        File file = new File(System.getProperty("user.dir") + "/sql");
//        if (!file.exists()) {
//            file.mkdir();
//        }
//        Runtime runtime = Runtime.getRuntime();
//        Process p = null;
//        //获取数据库的名字
//        String schema = getSchema();
//        //时间
//        String time = LocalDate.now() + "-" + LocalTime.now().getHour() + "-" + LocalTime.now().getMinute();
//        //获得未处理的地址
//        String location = System.getProperty("user.dir") + "/sql/" + time + "_" + schema + ".sql";
//        location = location.replaceAll("\\\\", "/");
//
//        final String COMMAND_SAVE_SQL = String.format("cmd /c mysqldump --default-character-set=utf8 -uroot -proot %s --hex-blob > %s", schema, location);
//        try {
//            //此处执行的是ipconfig命令，可以换成任何cmd 里的命令。
//            p = runtime.exec(COMMAND_SAVE_SQL);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (p != null) {
//                p.destroy();
//            }
//
//        }
//        logger.info("back UpData Schedule" + Calendar.getInstance().getTime());
//    }
//
//    /**
//     * 获取数据库的名字
//     *
//     * @return
//     */
//    public String getSchema() {
//        final String REGX = "[a-zA-Z0-9_]+\\?";
//        Matcher matcher = Pattern.compile(REGX).matcher(environment.getProperty("spring.datasource.url"));
//        if (matcher.find()) {
//            return matcher.group().substring(0, matcher.group().length() - 1);
//        } else {
//            throw new BusinessException("数据库不存在 请检查配置文件");
//        }
//    }
//}
