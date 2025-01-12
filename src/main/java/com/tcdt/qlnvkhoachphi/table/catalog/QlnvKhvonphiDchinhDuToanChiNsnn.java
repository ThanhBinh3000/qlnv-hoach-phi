package com.tcdt.qlnvkhoachphi.table.catalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "QLNV_KHVONPHI_DCHINH_DU_TOAN_CHI_NSNN")
@Data
@NamedEntityGraph(name = "QLNV_KHVONPHI_DCHINH_DU_TOAN_CHI_NSNN.listCtiet", attributeNodes = @NamedAttributeNode("listCtiet"))
public class QlnvKhvonphiDchinhDuToanChiNsnn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QLNV_KHVONPHI_DCHINH_DU_TOAN_CHI_NSNN_SEQ")
	@SequenceGenerator(sequenceName = "QLNV_KHVONPHI_DCHINH_DU_TOAN_CHI_NSNN_SEQ", allocationSize = 1, name = "QLNV_KHVONPHI_DCHINH_DU_TOAN_CHI_NSNN_SEQ")
	private Long id;

	String soQd;
	String maDvi;
	Long namHienHanh;
	Long duToanDc;
	Long kinhPhiTc;
	Long kinhPhiKhongTc;
	Date ngayQd;
	String trangThai;
	Date ngayTao;
	String nguoiTao;
	Date ngaySua;
	String nguoiSua;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "qlnvKhvonphiDchinhId")
	@JsonManagedReference
	private List<QlnvKhvonphiDchinhDuToanChiNsnnCtiet> listCtiet = new ArrayList<>();

	public void setListCtiet(List<QlnvKhvonphiDchinhDuToanChiNsnnCtiet> listCtiet) {
		this.listCtiet.clear();
		for (QlnvKhvonphiDchinhDuToanChiNsnnCtiet child : listCtiet) {
			child.setDchinhDuToanChiNsnn(this);
		}
		this.listCtiet.addAll(listCtiet);
	}

	public void addChild(QlnvKhvonphiDchinhDuToanChiNsnnCtiet child) {
		child.setDchinhDuToanChiNsnn(this);
		this.listCtiet.add(child);
	}
}
