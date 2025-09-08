package com.parcial_compi.demo;

import com.parcial_compi.demo.model.*;
import com.parcial_compi.demo.repo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

/* MALPARIDOS AQUI METEMOS COMO DATOS DE EJEMPLO PA PROBAR LA APLICACION */

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Datos de ejemplo al iniciar la app
    @Bean
    CommandLineRunner seedData(CliqueRepository cliqueRepo,
                               BullyRepository bullyRepo,
                               RevengePlanRepository planRepo,
                               MoodLogRepository moodRepo) {
        return args -> {
            // 1) Clique
            Clique popular = cliqueRepo.save(
                Clique.builder()
                        .name("Popular Kids")
                        .description("La rosca del cole")
                        .build()
            );

            // 2) Bully
            Bully kevin = bullyRepo.save(
                Bully.builder()
                        .name("Kevin")
                        .nickname("Kev")
                        .highSchoolRole(HighSchoolRole.JOCK)
                        .clique(popular)
                        .bullyingReason("Se burlaba en el prom")
                        .levelOfAnnoyance(8)
                        .build()
            );

            // 3) Revenge plans
            planRepo.saveAll(List.of(
                RevengePlan.builder()
                        .title("Meme del prom")
                        .description("Publicar el video llorando en historias")
                        .bully(kevin)
                        .isExecuted(true)
                        .datePlanned(LocalDate.now().minusDays(2))
                        .successLevel(SuccessLevel.ICONIC)
                        .build(),
                RevengePlan.builder()
                        .title("Sticker pack")
                        .description("Convertir sus fotos en stickers")
                        .bully(kevin)
                        .isExecuted(false)
                        .datePlanned(LocalDate.now().plusDays(5))
                        .successLevel(SuccessLevel.MILDLY_FUNNY)
                        .build()
            ));

            // 4) Mood log
            moodRepo.save(
                MoodLog.builder()
                        .date(LocalDate.now())
                        .moodLevel(9)
                        .note("Felt amazing after posting the meme.")
                        .build()
            );
        };
    }
}
