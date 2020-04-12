package velin.project.atelje117.model.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getUnpaidAmount() {
        return unpaidAmount;
    }

    public void setUnpaidAmount(int unpaidAmount) {
        this.unpaidAmount = unpaidAmount;
    }

    public int getGraniteCount() {
        return graniteCount;
    }

    public void setGraniteCount(int graniteCount) {
        this.graniteCount = graniteCount;
    }

    public int getPorcelainCount() {
        return porcelainCount;
    }

    public void setPorcelainCount(int porcelainCount) {
        this.porcelainCount = porcelainCount;
    }

    public ArtistUser getArtist() {
        return artist;
    }

    public void setArtist(ArtistUser artist) {
        this.artist = artist;
    }
}
