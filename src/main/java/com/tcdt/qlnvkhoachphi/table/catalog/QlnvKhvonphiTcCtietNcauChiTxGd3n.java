package com.tcdt.qlnvkhoachphi.table.catalog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "QLNV_KHVONPHI_TC_CTIET_NCAU_CHI_TX_GD3N")
@Data
public class QlnvKhvonphiTcCtietNcauChiTxGd3n implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QLNV_KHVONPHI_TC_CTIET_NCAU_CHI_TX_GD3N_SEQ")
	@SequenceGenerator(sequenceName = "QLNV_KHVONPHI_TC_CTIET_NCAU_CHI_TX_GD3N_SEQ", allocationSize = 1, name = "QLNV_KHVONPHI_TC_CTIET_NCAU_CHI_TX_GD3N_SEQ")
	private Long id;

	@Column(name = "QLNV_KHVONPHI_ID")
	private Long qlnvKhvonphiId;

	@Column(name = "STT")
	private Long stt;

	@Column(name = "MA_NDUNG")
	private String maNdung;

	@Column(name = "MA_NHOM_CHI")
	private String maNhomChi;

	@Column(name = "THIEN_NAM_HHANH_N")
	private String thienNamHhanhN;

	@Column(name = "NCAU_DTOAN_N1")
	private Long ncauDtoanN1;

	@Column(name = "NCAU_DTOAN_N2")
	private Long ncauDtoanN2;

	@Column(name = "NCAU_DTOAN_N3")
	private Long ncauDtoanN3;

}


