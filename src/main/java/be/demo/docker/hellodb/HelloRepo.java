package be.demo.docker.hellodb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepo extends JpaRepository<HelloMessage, Long> {
}
