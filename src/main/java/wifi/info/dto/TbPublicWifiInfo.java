package wifi.info.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TbPublicWifiInfo {
  int list_total_count;
  ResultMessage RESULT;
  List<WifiInfo> row;
}
