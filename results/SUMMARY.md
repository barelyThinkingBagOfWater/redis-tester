Tests done using Gatling framework, scenario : https://github.com/barelyThinkingBagOfWater/redis-tester/blob/master/load-tester/src/test/scala/Scenarios.scala
700'000k requests ramped during 30 seconds to save 1 big Json object in DB. 

Summary of the results :

ARTIFACTS                Avg requests/sec    % failed requests  Min response time  Max response time  Avg response timeStd deviation  Response time 50%  Response time 75%   Response time 95%   Response time 99%
Springmvc-redisson                   4697            1% (5180)                 94              75901              32079        14948              32908              43240               55999               62558
Springmvc-lettuce                    5185           2% (12411)                304              76098              30813        16566              29228              44015               58971               69270
Mn-redisson                          7291                    0                721              48401              18457         9235              16232              25974               34608               40780
Mn-lettuce                           8642                    0                802              35245              13474         6143              13148              17273               25083               28038
Quarkus-redisson                     7368                    0               1226              41276              17075         8086              15694              23097               32674               35864
Quarkus-lettuce                      8750                    0               1430              33417              12319         5261              12766              16279               20853               23656
Quarkus-lettuce-native               7526              0% (40)                  1              44697              15988         9391              14013              23506               32995               36838
Webflux-redisson                     7368            0% (1774)                188              42648              17104         7096              17325              22352               28844               32106
Webflux-lettuce                      7777             0% (236)                812              34411              14820         6177              15522              19862               23856               26927
