package wifi.info.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
// X_SWIFI_MGR_NO
// X_SWIFI_WRDOFC
// X_SWIFI_MAIN_NM
// X_SWIFI_ADRES1 
// X_SWIFI_ADRES2
// X_SWIFI_INSTL_FLOOR
// X_SWIFI_INSTL_TY
// X_SWIFI_INSTL_MBY
// X_SWIFI_SVC_SE
// X_SWIFI_CMCWR
// X_SWIFI_CNSTC_YEAR
// X_SWIFI_INOUT_DOOR
// X_SWIFI_REMARS3
// LAT
// LNT
// WORK_DTTM

@AllArgsConstructor
@Getter
@ToString
public class WifiInfo {
  private final String X_SWIFI_MGR_NO; // 관리번호
  private final String X_SWIFI_WRDOFC; // 자치구
  private final String X_SWIFI_MAIN_NM; // 와이파이명
  private final String X_SWIFI_ADRES1; // 도로명주소
  private final String X_SWIFI_ADRES2; // 상세주소
  private final String X_SWIFI_INSTL_FLOOR; // 설치위치 (층)
  private final String X_SWIFI_INSTL_TY; // 설치유형
  private final String X_SWIFI_INSTL_MBY; // 설치기관
  private final String X_SWIFI_SVC_SE; // 서비스구분
  private final String X_SWIFI_CMCWR; // 망종류
  private final String X_SWIFI_CNSTC_YEAR; // 설치년도
  private final String X_SWIFI_INOUT_DOOR; // 실내외구분
  private final String X_SWIFI_REMARS3; // wifi 접속환경
  private final String LAT; // Y 좌표
  private final String LNT; // X 좌표
  private final String WORK_DTTM; // 작업일자
}
