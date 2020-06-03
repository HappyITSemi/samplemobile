- - - - - - - - - - - - - - - - - - - - - - - - - - - -
alter table ITEM MODIFY (price number(10))

- - - - - - - - - - - - - - - - - - - - - - - - - - - -
create sequence "ITEMID_SEQ"
    start with 1
    increment by 1
    maxvalue 10000
    minvalue 1
    nocache
    cycle
    noorder;
- - - - - - - - - - - - - - - - - - - - - - - - - - - -

bigint    NUMBER(19.0)

int       NUMBER(10,0)
boolean   NUMBER(1)

text      VARCHAR2

date      DATE
datetime  DATE
time      DATE

char      CHAR

- - - - - - - - - - - - - - - - - - - - - - - - - - - -
nkfでSJISに変換

nkf -s /tmp/h_mypage_history.tsv > /tmp/h_mypage_history_sjis.tsv

export NLS_LANG=Japanese_Japan.AL32UTF8

- - - - exp/impで移行- - - - - - - - - - - - - - - - - -
expでデータのダンプ
exp userid=system/manager fromuser=schema table=(table1,table2...) file=(file1.dmp, file2.dmp,...) rows=y log=exp.log

impでデータダンプのロード
imp userid=system/manager fromuser=schema table=(table1,table2...) file=(file1.dmp, file2.dmp,...) rows=y log=imp.log

- - - - expdp/impdp で移行 or RMAN- - - - - - - - - - - -
expdpでデータのダンプ

create directory expdpdir as '/tmp';
expdp system/manager tables=employee directory=expdpdir dumpfile=expdp.dmp
impdpでデータダンプのロード

create directory imp dpdir as '/tmp';
impdp system/manager tables=employee directory=impdpdir dumpfile=expdp.dmp

- - - - RMANでバックアップの取得- - - - - - - - - - - - - - - -

rman target / nocatalog
backup database as compressed backupset plus archivelog;
exit;
RMANでバックアップのリカバリ

移行先へcontrol fileとinit.oraあるいはspfileのコピー
init.oraあるいはspfileでcovertの設定
rman target / nocatalog
set new_name
set untile to_date('2011/11/11 11:11:11', 'yyyy/mm/dd hh24:mi:ss');
backup database as compressed backupset plus archivelog;
exit;