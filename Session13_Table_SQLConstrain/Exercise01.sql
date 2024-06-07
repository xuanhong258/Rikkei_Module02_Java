CREATE DATABASE exercise01;
use exercise01;

create table vat_tu(
	maVT int primary key,
    tenVT varchar(100) not null
);

create table phieu_xuat(
	soPX int primary key,
    ngay_xuat date not null
);

create table phieu_xuat_chi_tiet(
	soPX int,
    foreign key(soPX) references phieu_xuat(soPX),
    maVT int,
    foreign key(maVT) references vat_tu(maVT),
    don_gia_xuat float check(don_gia_xuat > 0),
    so_luong_xuat float check(so_luong_xuat > 0)
);

create table phieu_nhap(
	soPN int primary key,
    ngay_nhap date not null
);

create table phieu_nhap_chi_tiet(
	soPN int,
    foreign key(soPN) references phieu_nhap(soPN),
    maVT int,
    foreign key(maVT) references vat_tu(maVT),
    don_gia_nhap float check(don_gia_nhap > 0),
    so_luong_nhap float check(so_luong_nhap > 0)
);

create table nha_cung_cap(
	maNCC int primary key,
    tenNCC varchar(100) not null,
    dia_chi text,
    so_dien_thoai text
);

create table don_dat_hang(
	soDH int primary key,
    ngayDH date not null,
    maNCC int,
    foreign key(maNCC) references nha_cung_cap(maNCC)
);

create table chi_tiet_don_dat_hang(
	maVT int,
    foreign key(maVT) references vat_tu(maVT),
	soDH int ,
    foreign key(soDH) references don_dat_hang(soDH)
);



