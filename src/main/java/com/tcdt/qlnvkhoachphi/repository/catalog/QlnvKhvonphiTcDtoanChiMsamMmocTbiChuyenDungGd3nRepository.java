package com.tcdt.qlnvkhoachphi.repository.catalog;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tcdt.qlnvkhoachphi.table.catalog.QlnvKhvonphiTcDtoanChiMsamMmocTbiChuyenDungGd3n;



public interface QlnvKhvonphiTcDtoanChiMsamMmocTbiChuyenDungGd3nRepository extends CrudRepository <QlnvKhvonphiTcDtoanChiMsamMmocTbiChuyenDungGd3n, Long>{
	String qlnvKhvonphiTcDtoanChiMsamMmocTbiChuyenDungGd3n = "SELECT * FROM QLNV_KHVONPHI_TC_DTOAN_CHI_MSAM_MMOC_TBI_CHUYEN_DUNG_GD3N t "
			+ "WHERE t.QLNV_KHVONPHI_ID = :qlnvKhvonphiId ";

	String tongHop = "SELECT ROWNUM as ID,a.* FROM (\r\n" + 
			"			    SELECT '' as QLNV_KHVONPHI_ID\r\n" + 
			"			    ,'' as STT\r\n" + 
			"			    ,t.MA_TBI as MA_VTU_TBI\r\n" + 
			"			    ,Sum(t.N1) as TCONG_N1\r\n" + 
			"			    ,Sum(t.N2) as TCONG_N2\r\n" + 
			"			    ,Sum(t.N3) as TCONG_N3\r\n" + 
			"						FROM (\r\n" + 
			"			                SELECT * FROM QLNV_KHVONPHI_DTOAN_CHI_MUASAM_MAYMOC_TBI_GD3N ct \r\n" + 
			"			                INNER JOIN QLNV_KHVONPHI vp ON vp.id = ct.qlnv_khvonphi_id \r\n" + 
			"			                INNER JOIN qlnv_dm_donvi dv ON dv.id = vp.ma_dvi WHERE dv.ma_dvi_cha=:maDviCha AND vp.nam_hien_hanh=:namHienHanh) t \r\n" + 
			"						GROUP BY t.MA_TBI) a";

	@Query(value = tongHop, nativeQuery = true)
	ArrayList<QlnvKhvonphiTcDtoanChiMsamMmocTbiChuyenDungGd3n> synthesis(String maDviCha, String namHienHanh);

	@Query(value = qlnvKhvonphiTcDtoanChiMsamMmocTbiChuyenDungGd3n, nativeQuery = true)
	ArrayList<QlnvKhvonphiTcDtoanChiMsamMmocTbiChuyenDungGd3n> findQlnvKhvonphiTcDtoanChiMsamMmocTbiChuyenDungGd3nByQlnvKhvonphiId(Long qlnvKhvonphiId);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM QLNV_KHVONPHI_TC_DTOAN_CHI_MSAM_MMOC_TBI_CHUYEN_DUNG_GD3N u WHERE u.ID in ?1", nativeQuery = true)
	int deleteWithIds(List<Long> ids);

}
