package org.isf.disease.service;

import java.util.List;

import org.isf.disease.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface DiseaseIoOperationRepository extends JpaRepository<Disease, String> {   
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A WHERE DIS_ID_A = :code", nativeQuery= true)
    public Disease findOneByCode(@Param("code") int code);
    @Query(value = "SELECT * FROM DISEASE WHERE DIS_DESC = :description AND DIS_DCL_ID_A = :code", nativeQuery= true)
    public Disease findOneByDescriptionAndTypeCode(@Param("description") String description, @Param("code") String code);    

    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A where DCL_ID_A like :code order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAllByDiseaseTypeCode(@Param("code") String code);
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A where DCL_ID_A like :code and (DIS_OPD_INCLUDE=1 or DIS_OPD_INCLUDE is null) order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAllByDiseaseTypeCodeAndOpd(@Param("code") String code);
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A where DCL_ID_A like :code and (DIS_IPD_IN_INCLUDE=1 or DIS_IPD_IN_INCLUDE is null) order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAllByDiseaseTypeCodeAndIpdIn(@Param("code") String code);
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A where DCL_ID_A like :code and (DIS_IPD_OUT_INCLUDE=1 or DIS_IPD_OUT_INCLUDE is null) order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAllByDiseaseTypeCodeAndIpdOut(@Param("code") String code);    
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A where DCL_ID_A like :code and (DIS_IPD_IN_INCLUDE=1 or DIS_IPD_IN_INCLUDE is null) and  (DIS_IPD_IN_INCLUDE=1 or DIS_IPD_IN_INCLUDE is null) order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAllByDiseaseTypeCodeAndOpdAndIpdIn(@Param("code") String code);
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A where DCL_ID_A like :code and (DIS_IPD_IN_INCLUDE=1 or DIS_IPD_IN_INCLUDE is null) and (DIS_IPD_OUT_INCLUDE=1 or DIS_IPD_OUT_INCLUDE is null) order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAllByDiseaseTypeCodeAndOpdAndIpdOut(@Param("code") String code);
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A where DCL_ID_A like :code and (DIS_IPD_IN_INCLUDE=1 or DIS_IPD_IN_INCLUDE is null) and (DIS_IPD_OUT_INCLUDE=1 or DIS_IPD_OUT_INCLUDE is null) order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAllByDiseaseTypeCodeAndIpdInAndIpdOut(@Param("code") String code);
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A where DCL_ID_A like :code and (DIS_IPD_IN_INCLUDE=1 or DIS_IPD_IN_INCLUDE is null) and  (DIS_IPD_IN_INCLUDE=1 or DIS_IPD_IN_INCLUDE is null) and (DIS_IPD_OUT_INCLUDE=1 or DIS_IPD_OUT_INCLUDE is null) order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAllByDiseaseTypeCodeAndOpdAndIpdInAndIpdOut(@Param("code") String code);
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAll();
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A where (DIS_OPD_INCLUDE=1 or DIS_OPD_INCLUDE is null) order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAllByOpd();
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A where (DIS_IPD_IN_INCLUDE=1 or DIS_IPD_IN_INCLUDE is null) order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAllByIpdIn();
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A where (DIS_IPD_OUT_INCLUDE=1 or DIS_IPD_OUT_INCLUDE is null) order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAllByIpdOut();    
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A where (DIS_IPD_IN_INCLUDE=1 or DIS_IPD_IN_INCLUDE is null) and  (DIS_IPD_IN_INCLUDE=1 or DIS_IPD_IN_INCLUDE is null) order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAllByOpdAndIpdIn();
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A where (DIS_IPD_IN_INCLUDE=1 or DIS_IPD_IN_INCLUDE is null) and (DIS_IPD_OUT_INCLUDE=1 or DIS_IPD_OUT_INCLUDE is null) order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAllByOpdAndIpdOut();
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A where (DIS_IPD_IN_INCLUDE=1 or DIS_IPD_IN_INCLUDE is null) and (DIS_IPD_OUT_INCLUDE=1 or DIS_IPD_OUT_INCLUDE is null) order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAllByIpdInAndIpdOut();
    @Query(value = "SELECT * FROM DISEASE JOIN DISEASETYPE ON DIS_DCL_ID_A = DCL_ID_A where (DIS_IPD_IN_INCLUDE=1 or DIS_IPD_IN_INCLUDE is null) and  (DIS_IPD_IN_INCLUDE=1 or DIS_IPD_IN_INCLUDE is null) and (DIS_IPD_OUT_INCLUDE=1 or DIS_IPD_OUT_INCLUDE is null) order BY DIS_DESC", nativeQuery= true)
    public List<Disease> findAllByOpdAndIpdInAndIpdOut();    
}