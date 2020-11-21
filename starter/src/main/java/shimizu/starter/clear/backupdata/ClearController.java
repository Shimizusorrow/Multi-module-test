package shimizu.starter.clear.backupdata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

/**
 * @author shimizu
 * @date 2020年11月21日08:44:58
 */
@RestController
@RequestMapping
@Slf4j
public class ClearController {

    @GetMapping
    public void backupData() throws IOException {
        String schema = "shimizu";
        String location = String.format("/usr/work/multi-module-test/sql/%s-shimizu.sql", (int) (Math.random() * 9999));
        String COMMAND_SAVE_SQL[] = {"/bin/sh", "-c", String.format(
                "mysqldump --default-character-set=utf8 -uroot -proot %s --hex-blob > %s", schema, location)};
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(COMMAND_SAVE_SQL);
        log.info(location);
    }

    @GetMapping("/lower")
    public void backupDataLower(){
        String schema = "shimizu";
        String location = String.format("/usr/work/multi-module-test/sql/%s-shimizu.sql", "lower-"+(int) (Math.random() * 9999));
        String COMMAND_SAVE_SQL[] = {"/bin/sh", "-c", String.format(
                "mysqldump -uroot -proot %s > %s", schema, location)};
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(COMMAND_SAVE_SQL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(location);
    }
}
