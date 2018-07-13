create database QuanLyThuVien
go
use QuanLyThuVien
go
set dateformat dmy
go
create table NhanVien(
	MaNhanVien int identity(1,1) not null ,
	Tendangnhap varchar(25) not null unique,
	MatKhau varchar(32) not null,
	HoTen nvarchar(50) not null,
	CMND nvarchar(20) not null unique,
	Anh Image not null,
	DiaChi nvarchar(50) not null,
	DienThoai nvarchar(20) not null,
	Email nvarchar(30) not null unique,
	NgaySinh datetime not null,
	GioiTinh bit,
	NgayTao date not null,
	PhanQuyen tinyint not null,
	TrangThai tinyint default 1,
	CONSTRAINT pk1 PRIMARY KEY (MaNhanVien),
)
go
create table BanDoc(
	MaBanDoc int identity(1,1) not null ,
	Tendangnhap varchar(25) not null unique,
	MatKhau varchar(32) not null,
	HoTen nvarchar(50) not null,
	CMND nvarchar(20) not null unique,
	Anh Image not null,
	DiaChi nvarchar(50) not null,
	DienThoai nvarchar(20) not null unique,
	Email nvarchar(30) not null unique,
	TienCuoc nvarchar(50) not null,
	NgaySinh date not null,
	GioiTinh bit,
	NgayTao date not null,
	NgayHetHan date ,
	TrangThai tinyint default 1,
	CONSTRAINT pk2 PRIMARY KEY (MaBanDoc),
)
go
create table TacGia(
	MaTacGia int identity(1,1) not null ,
	TenTacGia nvarchar(100) not null unique,
	CONSTRAINT pk3 PRIMARY KEY (MaTacGia),
)
go
create table NhaXB(
	MaNXB int identity(1,1) not null ,
	TenNXB nvarchar(50) not null unique,
	DienThoai nvarchar(11) not null,
	DiaChi nvarchar(200) not null,
	CONSTRAINT pk4 PRIMARY KEY (MaNXB),
)
go
create table TheLoai(
	MaTheLoai int identity(1,1) not null ,
	TenTheLoai nvarchar(50) not null unique,
	CONSTRAINT pk5 PRIMARY KEY (MaTheLoai),
)
go
create table NgonNgu(
	MaNgonNgu int identity(1,1) not null ,
	TenNgonNgu nvarchar(50) not null unique,
	CONSTRAINT pk6 PRIMARY KEY (MaNgonNgu),
)
go
create table Sach(
	MaSach int identity(1,1) not null ,
	TenSach nvarchar(200) not null,
	MaNXB int not null,
	MaTacGia int not null,
	MaTheLoai int not null,
	TomTat ntext not null,
	NgayXB date not null,
	SoTrang int not null,
	MaNgonNgu int not null,
	Bia Image not null,
	GiaBan int not null,
	Soluong int not null,
	SoMat int not null default 0,
	Tang nvarchar(10) not null,
	Phong nvarchar(10) not null,
	Gia nvarchar(10) not null,
	Ke nvarchar(10) not null,
	Trangthai tinyint not null default 1,
	CONSTRAINT pk8 PRIMARY KEY (MaSach),
	CONSTRAINT fk1 FOREIGN KEY (MaTacGia) REFERENCES TacGia(MaTacGia),
	CONSTRAINT fk2 FOREIGN KEY (MaNXB) REFERENCES NhaXB(MaNXB),
	CONSTRAINT fk3 FOREIGN KEY (MaTheLoai) REFERENCES TheLoai(MaTheLoai),
	CONSTRAINT fk4 FOREIGN KEY (MaNgonNgu) REFERENCES NgonNgu(MaNgonNgu),
)
go
create table PhieuMuon(
	MaPhieuMuon int identity(1,1) not null ,
	MaNhanVien int not null,
	MaBanDoc int not null,
	NgayMuon date not null,
	NgayTra date,
	HanTra date not null,
	TienPhat int DEFAULT 0,
	TrangThai tinyint DEFAULT 1,
	CONSTRAINT pk9 PRIMARY KEY (MaPhieuMuon),
	CONSTRAINT fk5 FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien),
	CONSTRAINT fk6 FOREIGN KEY (MaBanDoc) REFERENCES BanDoc(MaBanDoc),
)
go
create table ChiTietPhieuMuon(
	MaPhieuMuon int not null,
	MaSach int not null,
	SoLuong int default 1,
	TrangThaiSach tinyint DEFAULT 1,
	CONSTRAINT fk7 FOREIGN KEY (MaPhieuMuon) REFERENCES PhieuMuon(MaPhieuMuon),
	CONSTRAINT fk8 FOREIGN KEY (MaSach) REFERENCES Sach(MaSach),
)
create procedure CountNV (@Count int)
as
begin
	IF(GETDATE()<(SELECT NgayHetHan FROM BanDoc WHERE MaBanDoc=@MaBanDoc))
		UPDATE BanDoc SET NgayHetHan=DATEADD(YY,1,NgayHetHan) WHERE MaBanDoc=@MaBanDoc
	ELSE
		UPDATE BanDoc SET NgayHetHan=DATEADD(YY,1,GETDATE()) WHERE MaBanDoc=@MaBanDoc
end
go

select top 10 MaTacGia as 'Mã Tác Giả', TenTacGia as 'Tên Tác Giả' from TacGia where TenTacGia LIKE '%a%' and MaTacGia not in (select top (2 * 10 - 10) MaTacGia from TacGia where TenTacGia LIKE '%a%' order by MaTacGia) order by MaTacGia asc
select top 10 MaBanDoc as 'Mã Bạn Đọc', HoTen as 'Họ Tên', DiaChi as 'Địa Chỉ', NgaySinh as 'Ngày Sinh', DienThoai as 'Điện thoại', Email,GioiTinh as 'Giới Tính',NgayHetHan as 'Hạn Thẻ', TienCuoc as 'Tiền Cược', TrangThai as 'Trạng thái' from BanDoc
                            where MaBanDoc not in (select top (1 * 10 - 10) MaBanDoc from BanDoc where TrangThai is not null order by MaBanDoc asc)
                            and TrangThai is not null order by MaBanDoc asc

select top 10 MaBanDoc as 'Mã Bạn Đọc',HoTen as 'Họ Tên', DiaChi as 'Địa Chỉ',
                           NgaySinh as 'Ngày Sinh', DienThoai as 'Điện thoại', Email as 'Email',GioiTinh as 'Giới Tính',NgayHetHan as 'Hạn Thẻ', TienCuoc as 'Tiền Cược', TrangThai as 'Trạng thái'
                          from BanDoc
                          where MaBanDoc not in (select top (2 * 10 - 10) MaBanDoc from BanDoc where TrangThai is not null order by MaBanDoc asc)
                           and TrangThai is not null order by MaBanDoc asc
delete from BanDoc
INSERT INTO NhaXB(TenNXB,DienThoai,DiaChi) VALUES ('a','a','v')
select MaNXB,TenNXB,DienThoai, DiaChi from NhaXB where MaNXB = 1
UPDATE NhanVien SET TrangThai=1 WHERE MaNhanVien=1
UPDATE BanDoc SET NgayHetHan='2017-04-09' WHERE MaBanDoc=1
UPDATE BanDoc SET TrangThai=1 WHERE MaBanDoc=1
insert into BanDoc(Tendangnhap,MatKhau,HoTen,CMND,Anh,DiaChi,DienThoai,Email,TienCuoc,NgaySinh,GioiTinh,NgayTao,NgayHetHan,TrangThai) values ('a','b','a3445535441','1244554354233','aa35435544a3a',N'Phòng 507-E3 Thành Công - Ba Đình - Hà Nội','4553a345414','4555343a414',500000,'16-12-2010',1,'12-12-2016','19-11-2018',1)
select NgayHetHan from BanDoc where MaBanDoc=1
select count(*) from NhanVien where Tendangnhap='a' and Matkhau='a' and TrangThai!=0
select MaNhanVien from NhanVien where Tendangnhap='a' and Matkhau='b'
select*from NhaXB where MaNXB='2'
select*from NhanVien 
select*from BanDoc 
select TrangThai from BanDoc
select PhanQuyen from NhanVien where Tendangnhap='b' and Matkhau='b1'
select (count(*)/10+1) from TacGia where TenTacGia LIKE '%a1%'
insert into TacGia(TenTacGia) values ('a10 4');
select top 5 MaTacGia as 'Mã Tác Giả', TenTacGia as 'Tên Tác Giả' from TacGia
                    where MaTacGia not in (select top (2 * 5 - 5) MaTacGia from TacGia ) and TenTacGia like '%a%'
					UPDATE BanDoc SET NgayHetHan = '2017/04/09' WHERE MaBanDoc = 1
select count(*) from ChiTietPhieuMuon join PhieuMuon on ChiTietPhieuMuon.MaPhieuMuon=PhieuMuon.MaPhieuMuon where PhieuMuon.MaBanDoc=1
select count(*) from Sach join TacGia on Sach.MaTacGia=TacGia.MaTacGia where TacGia.TenTacGia LIKE '%a%'
UPDATE BanDoc SET NgayHetHan = TO_DATE('19/12/2016','mm/dd/yyyy') WHERE MaBanDoc = 1
select* from BanDoc where NgayHetHan< CONVERT(VARCHAR(10),GETDATE(),111)
create procedure GiaHanBD (@MaBanDoc int)
as
begin
	IF(GETDATE()<(SELECT NgayHetHan FROM BanDoc WHERE MaBanDoc=@MaBanDoc))
		UPDATE BanDoc SET NgayHetHan=DATEADD(YY,1,NgayHetHan) WHERE MaBanDoc=@MaBanDoc
	ELSE
		UPDATE BanDoc SET NgayHetHan=DATEADD(YY,1,GETDATE()) WHERE MaBanDoc=@MaBanDoc
end
go
	
	EXEC GiaHanBD '6'

select top 10 MaSach as 'Mã Sách',TenSach as 'Tên sách',NhaXB.TenNXB as 'Tên nhà xuất bản',TacGia.TenTacGia as 'Tên tác giả',TheLoai.TenTheLoai as 'Tên thể loại',NgonNgu.TenNgonNgu as 'Ngôn ngữ', TomTat as 'Tóm tắt',
                        NgayXB as 'Ngày xuất bản', GiaBan as 'Giá bán', SoLuong-SoMat as 'Số Lượng',Tang as 'Tầng', 
                        Phong as 'Phòng', Gia as 'Giá',Ke as 'Kệ', TrangThai as 'Trạng thái' 
                       from Sach join NhaXB on Sach.MaNXB=NhaXB.MaNXB 
                        join TacGia on Sach.MaTacGia=TacGia.MaTacGia 
                       join TheLoai on Sach.MaTheLoai=TheLoai.MaTheLoai 
                        join NgonNgu on Sach.MaNgonNgu=NgonNgu.MaNgonNgu 

ALTER DATABASE QuanLyThuVien SET ONLINE; 

select*from Sach

SELECT TOP 10 ChiTietPhieuMuon.MaPhieuMuon AS 'Mã Phiếu Mượn', BanDoc.HoTen as 'Tên Người Mượn', PhieuMuon.NgayMuon as 'Ngày Mượn', ChiTietPhieuMuon.TrangThaiSach AS 'Trạng Thái' 
                    FROM ChiTietPhieuMuon JOIN PhieuMuon ON ChiTietPhieuMuon.MaPhieuMuon = PhieuMuon.MaPhieuMuon 
                    JOIN BanDoc ON PhieuMuon.MaBanDoc= BanDoc.MaBanDoc 
                   WHERE ChiTietPhieuMuon.MaSach =1 AND ChiTietPhieuMuon.TrangThaiSach != 0 AND 
                  ChiTietPhieuMuon.MaPhieuMuon NOT IN (SELECT TOP (1 * 10 - 10) ChiTietPhieuMuon.MaPhieuMuon FROM ChiTietPhieuMuon WHERE ChiTietPhieuMuon.MaSach =1 AND ChiTietPhieuMuon.TrangThaiSach !=0 ORDER BY ChiTietPhieuMuon.MaPhieuMuon DESC) 
           ORDER BY ChiTietPhieuMuon.MaPhieuMuon DESC

SELECT SUM(SoLuong) FROM ChiTietPhieuMuon WHERE MaSach = 1 AND TrangThaiSach=1
SELECT coalesce(SUM(SoLuong),0) FROM ChiTietPhieuMuon WHERE MaSach = 1 AND TrangThaiSach=1
select top 10 Sach.MaSach as 'Mã Sách',Sach.TenSach as 'Tên sách',NhaXB.TenNXB as 'Tên nhà xuất bản',TacGia.TenTacGia as 'Tên tác giả',TheLoai.TenTheLoai as 'Tên thể loại',NgonNgu.TenNgonNgu as 'Ngôn ngữ',Sach.TomTat as 'Tóm tắt', 
                       Sach.NgayXB as 'Ngày xuất bản', Sach.GiaBan as 'Giá bán', Sach.SoLuong as 'Số Lượng Nhập', Sach.SoLuong-Sach.SoMat as 'Số hiện có', Sach.Tang as 'Tầng', 
                      Sach.Phong as 'Phòng', Sach.Gia as 'Giá',Sach.Ke as 'Kệ', Sach.TrangThai as 'Trạng thái' 
                   from Sach join NhaXB on Sach.MaNXB=NhaXB.MaNXB 
                 join TacGia on Sach.MaTacGia=TacGia.MaTacGia 
               join TheLoai on Sach.MaTheLoai=TheLoai.MaTheLoai 
              join NgonNgu on Sach.MaNgonNgu=NgonNgu.MaNgonNgu 
                 order by Sach.MaSach asc

				 SELECT (SoLuong - SoMat -(SELECT coalesce(SUM(SoLuong),0) FROM ChiTietPhieuMuon WHERE MaSach = 1 AND TrangThaiSach=1)) FROM Sach WHERE MaSach =1

				 ALTER TABLE Sach ALTER COLUMN TomTat ntext not null

SELECT COUNT(*) FROM BanDoc WHERE MaBanDoc =66

ALTER proc [dbo].[BackupData]
(
	@TenDB varchar(30),
	@Link varchar(500)
)
as
begin
backup database @TenDB to disk = @Link with format, medianame = 'test',name = 'back up of the quanlihocsinh database'
end

use QuanLyThuVien
go
create procedure backupdl (@Link varchar(500))
as
begin
	BACKUP DATABASE QuanLyThuVien TO DISK =@Link WITH INIT
end
go