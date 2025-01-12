package com.tcdt.qlnvkhoachphi.table.catalog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Table(name = "QLNV_KHVONPHI_DCHINH_DU_TOAN_CHI_NSNN_CTIET")
@Data
public class QlnvKhvonphiDchinhDuToanChiNsnnCtiet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QLNV_KHVONPHI_DCHINH_DU_TOAN_CHI_NSNN_CTIET_SEQ")
	@SequenceGenerator(sequenceName = "QLNV_KHVONPHI_DCHINH_DU_TOAN_CHI_NSNN_CTIET_SEQ", allocationSize = 1, name = "QLNV_KHVONPHI_DCHINH_DU_TOAN_CHI_NSNN_CTIET_SEQ")
	private Long id;

//	@Column(name = "QLNV_KHVONPHI_DCHINH_ID")
//	private Long qlnvKhvonphiDchinhId;

	@Column(name = "MA_DVI")
	private String maDvi;

	@Column(name = "MA_KHOAN_MUC")
	private String maKhoanMuc;

	@Column(name = "MA_NOI_DUNG")
	private String maNoiDung;

	@Column(name = "MA_NHOM_CHI")
	private String maNhomChi;

	@Column(name = "TONG_TIEN")
	private Long tongTien;

	@Column(name = "GHI_CHU")
	private String ghiChu;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "qlnvKhvonphiDchinhId")
	@JsonBackReference

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinTable(name = "QLNV_KHVONPHI_DCHINH_DU_TOAN_CHI_NSNN", joinColumns = @JoinColumn(name = "id"))
	private QlnvKhvonphiDchinhDuToanChiNsnn dchinhDuToanChiNsnn;

}
