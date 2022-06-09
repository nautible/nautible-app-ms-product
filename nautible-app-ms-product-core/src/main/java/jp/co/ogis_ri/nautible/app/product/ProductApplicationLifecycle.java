package jp.co.ogis_ri.nautible.app.product;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

import javax.enterprise.event.Observes;

import org.eclipse.microprofile.config.ConfigProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

public class ProductApplicationLifecycle {
    private static final Logger logger = LoggerFactory.getLogger(ProductApplicationLifecycle.class);

    void onStart(@Observes StartupEvent event) {
        logger.info("start " + ProductApplicationLifecycle.class.getSimpleName() +"#onStart.");

        if (logger.isDebugEnabled()) {
            String dbHost = ConfigProvider.getConfig().getOptionalValue("db.host", String.class).orElseGet(() -> {
                logger.debug("try get from quarkus config but not found with key = db.host, so try get from system prop.");
                return System.getProperty("DB_HOST");
            });
            logger.debug("use this dbHost=" + dbHost);
    
            try {
                logger.debug("InetAddress.getByName(dbHost).isReachable(3000) = "
                        + InetAddress.getByName(dbHost).isReachable(3000));
            } catch (IOException e) {
                logger.error("fail resolve dbHost = " + dbHost, e);
                throw new RuntimeException(e);
            }
    
            String dbKind = ConfigProvider.getConfig().getValue("quarkus.datasource.db-kind", String.class);
            String userName = ConfigProvider.getConfig().getValue("quarkus.datasource.username", String.class);
            String password = ConfigProvider.getConfig().getValue("quarkus.datasource.password", String.class);
            String jdbcURL = ConfigProvider.getConfig().getValue("quarkus.datasource.jdbc.url", String.class);
    
            logger.debug("try isReachable to RDS. dbKind = " + dbKind + ", userName = " + userName + ", password = "
                    + password + ", jdbcURL = " + jdbcURL);
    
            String driverName = "com.mysql.cj.jdbc.Driver";
            Connection conn = null;
            try {
                Class.forName(driverName);
                conn = DriverManager.getConnection(jdbcURL, userName, password);
            } catch (ClassNotFoundException e) {
                logger.error("not found " + dbKind + " Driver = " + driverName, e);
                throw new RuntimeException(e);
            } catch (SQLException e) {
                logger.error("open connection failed.", e);
                throw new RuntimeException(e);
            } finally {
                try {
                    if (!Objects.isNull(conn) && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    logger.debug("close connection failed.", e);
                }
            }
        }

        logger.info("end " + ProductApplicationLifecycle.class.getSimpleName() + "#onStart.");
    }

    void onStop(@Observes ShutdownEvent event) {
        logger.info("start " + ProductApplicationLifecycle.class.getSimpleName() + "#onStop.");
        logger.info("end " + ProductApplicationLifecycle.class.getSimpleName() + "#onStop.");
    }
}