package com.tcdt.qlnvkhoachphi.repository.catalog;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tcdt.qlnvkhoachphi.table.catalog.QlnvKhvonphiDtoanChiMuasamMaymocTbiGd3n;

public interface QlnvKhvonphiDtoanChiMuasamMaymocTbiGd3nRepository extends CrudRepository <QlnvKhvonphiDtoanChiMuasamMaymocTbiGd3n, Long>{
	String qlnvKhvonphiDtoanChiMuasamMaymocTbiGd3n = "SELECT * FROM QLNV_KHVONPHI_DTOAN_CHI_MUASAM_MAYMOC_TBI_GD3N t "
			+ "WHERE (:qlnvKhvonphiId is null or t.QLNV_KHVONPHI_ID = :qlnvKhvonphiId) ";

	String tongHop = "SELECT ROWNUM as ID,a.* FROM (\r\n" + 
			"    SELECT '' as QLNV_KHVONPHI_ID\r\n" + 
			"    ,'' as STT\r\n" + 
			"    ,t.MA_TBI\r\n" + 
			"    ,Sum(t.N1) as N1\r\n" + 
			"    ,Sum(t.N2) as N2\r\n" + 
			"    ,Sum(t.N3) as N3\r\n" + 
			"			FROM (\r\n" + 
			"                SELECT * FROM QLNV_KHVONPHI_DTOAN_CHI_MUASAM_MAYMOC_TBI_GD3N ct \r\n" + 
			"                INNER JOIN QLNV_KHVONPHI vp ON vp.id = ct.qlnv_khvonphi_id \r\n" + 
			"                INNER JOIN qlnv_dm_donvi dv ON dv.id = vp.ma_dvi WHERE dv.ma_dvi_cha=:maDviCha AND vp.nam_hien_hanh=:namHienHanh) t \r\n" + 
			"			GROUP BY t.MA_TBI) a";

	@Query(value = tongHop, nativeQuery = true)
	ArrayList<QlnvKhvonphiDtoanChiMuasamMaymocTbiGd3n> synthesis(String maDviCha, String namHienHanh);
	
	@Query(value = qlnvKhvonphiDtoanChiMuasamMaymocTbiGd3n, nativeQuery = true)
	ArrayList<QlnvKhvonphiDtoanChiMuasamMaymocTbiGd3n> findQlnvKhvonphiDtoanChiMuasamMaymocTbiGd3nByQlnvKhvonphiId(Long qlnvKhvonphiId);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM QLNV_KHVONPHI_DTOAN_CHI_MUASAM_MAYMOC_TBI_GD3N u WHERE u.ID in ?1", nativeQuery = true)
	int deleteWithIds(List<Long> ids);

}
