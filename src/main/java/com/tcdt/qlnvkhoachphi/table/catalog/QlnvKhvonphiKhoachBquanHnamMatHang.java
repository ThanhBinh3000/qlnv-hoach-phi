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
@Table(name = "QLNV_KHVONPHI_KHOACH_BQUAN_HNAM_MAT_HANG")
@Data
public class QlnvKhvonphiKhoachBquanHnamMatHang implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QLNV_KHVONPHI_KHOACH_BQUAN_HNAM_MAT_HANG_SEQ")
	@SequenceGenerator(sequenceName = "QLNV_KHVONPHI_KHOACH_BQUAN_HNAM_MAT_HANG_SEQ", allocationSize = 1, name = "QLNV_KHVONPHI_KHOACH_BQUAN_HNAM_MAT_HANG_SEQ")
	private Long id;

	@Column(name = "QLNV_KHVONPHI_ID")
	private Long qlnvKhvonphiId;

	@Column(name = "STT")
	private Long stt;

	@Column(name = "MA_MAT_HANG")
	private String maMatHang;

	@Column(name = "MA_NHOM")
	private String maNhom;

	@Column(name = "KPHI")
	private Long kPhi;

}
