USE [JavaHibernate_Day8_Lap5]
GO
/****** Object:  Table [dbo].[tbProduct]    Script Date: 2/28/2024 9:30:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbProduct](
	[MaSP] [nvarchar](5) NOT NULL,
	[TenSanPham] [nvarchar](500) NULL,
	[AnhSanPham] [nvarchar](500) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[TrangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tbProduct] ([MaSP], [TenSanPham], [AnhSanPham], [SoLuong], [DonGia], [TrangThai]) VALUES (N'P0001', N'Ban uong nuoc', N'P0001.jpg', 100, 1000, 1)
INSERT [dbo].[tbProduct] ([MaSP], [TenSanPham], [AnhSanPham], [SoLuong], [DonGia], [TrangThai]) VALUES (N'P0002', N'Ke de do', N'P0002.jpg', 50, 5000, 1)
INSERT [dbo].[tbProduct] ([MaSP], [TenSanPham], [AnhSanPham], [SoLuong], [DonGia], [TrangThai]) VALUES (N'P0003', N'Ke giuong', N'P0003.jpg', 20, 1000, 0)
GO
