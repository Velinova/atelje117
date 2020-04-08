package velin.project.atelje117.model.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "reports")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MonthlyReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false)
    private int id;
    @Column(name = "income",  nullable = false)
    private int income;
    @Column(name = "month",  nullable = false)
    private Date month;
    @Column(name = "profit",  nullable = false)
    private int profit;
    @Column(name = "unpaid",  nullable = false)
    private int unpaidAmount;
    @Column(name = "graniteCount",  nullable = false)
    private int graniteCount;
    @Column(name = "porcelainCount",  nullable = false)
    private int porcelainCount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artistId", nullable = false)
    private ArtistUser artist;


}
