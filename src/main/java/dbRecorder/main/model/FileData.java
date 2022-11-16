package dbRecorder.main.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "file_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    byte[] fileData;

    @JsonFormat(timezone = "Europe/Warsaw")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="added_day",nullable = false, updatable = false)
    @JsonIgnore
    Date addedDay;

    @NonNull
    String originalFileName;

    @NonNull
    String contentType;
}
