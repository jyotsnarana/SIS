/*    ==Scripting Parameters==

    Source Server Version : SQL Server 2016 (13.0.4001)
    Source Database Engine Edition : Microsoft SQL Server Enterprise Edition
    Source Database Engine Type : Standalone SQL Server

    Target Server Version : SQL Server 2017
    Target Database Engine Edition : Microsoft SQL Server Standard Edition
    Target Database Engine Type : Standalone SQL Server
*/
USE [master]
GO
/****** Object:  Database [sis_db]    Script Date: 12/5/2017 3:38:08 AM ******/
CREATE DATABASE [sis_db]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'sis_db', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER01\MSSQL\DATA\sis_db.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'sis_db_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER01\MSSQL\DATA\sis_db_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [sis_db] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [sis_db].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [sis_db] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [sis_db] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [sis_db] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [sis_db] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [sis_db] SET ARITHABORT OFF 
GO
ALTER DATABASE [sis_db] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [sis_db] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [sis_db] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [sis_db] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [sis_db] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [sis_db] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [sis_db] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [sis_db] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [sis_db] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [sis_db] SET  DISABLE_BROKER 
GO
ALTER DATABASE [sis_db] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [sis_db] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [sis_db] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [sis_db] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [sis_db] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [sis_db] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [sis_db] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [sis_db] SET RECOVERY FULL 
GO
ALTER DATABASE [sis_db] SET  MULTI_USER 
GO
ALTER DATABASE [sis_db] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [sis_db] SET DB_CHAINING OFF 
GO
ALTER DATABASE [sis_db] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [sis_db] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [sis_db] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'sis_db', N'ON'
GO
ALTER DATABASE [sis_db] SET QUERY_STORE = OFF
GO
USE [sis_db]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [sis_db]
GO
/****** Object:  User [jyotsna]    Script Date: 12/5/2017 3:38:10 AM ******/
CREATE USER [jyotsna] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[addcourse]    Script Date: 12/5/2017 3:38:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[addcourse](
	[Term] [nchar](10) NULL,
	[Course] [nchar](10) NULL,
	[Description] [nchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[capacity]    Script Date: 12/5/2017 3:38:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[capacity](
	[Course] [nchar](10) NULL,
	[Description] [nchar](20) NULL,
	[Schedule] [nchar](20) NULL,
	[Time] [nchar](10) NULL,
	[Room] [nchar](10) NULL,
	[Capacity] [nchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[login_1]    Script Date: 12/5/2017 3:38:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[login_1](
	[username] [nchar](10) NULL,
	[password] [nchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[register_student]    Script Date: 12/5/2017 3:38:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[register_student](
	[Term] [nchar](10) NULL,
	[Course] [nchar](10) NOT NULL,
	[Description] [nchar](10) NULL,
	[Professor] [nchar](10) NULL,
	[Start date] [nchar](10) NULL,
	[End date] [nchar](10) NULL,
	[Start time] [nchar](10) NULL,
	[End time] [nchar](10) NULL,
	[Vacancy] [nchar](10) NULL,
 CONSTRAINT [PK_register_student] PRIMARY KEY CLUSTERED 
(
	[Course] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[soen6441]    Script Date: 12/5/2017 3:38:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[soen6441](
	[StudentID] [nchar](20) NULL,
	[Grade] [nchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 12/5/2017 3:38:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[ID] [nchar](10) NULL,
	[Name] [nchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[transcript]    Script Date: 12/5/2017 3:38:11 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[transcript](
	[Term] [nchar](10) NULL,
	[Course] [nchar](10) NULL,
	[Description] [nchar](20) NULL,
	[Grade] [nchar](10) NULL,
	[GPA] [nchar](10) NULL,
	[Term_GPA] [nchar](10) NULL
) ON [PRIMARY]
GO
INSERT [dbo].[addcourse] ([Term], [Course], [Description]) VALUES (N'summer18  ', N'COMP6411  ', N'COMPARA   ')
INSERT [dbo].[addcourse] ([Term], [Course], [Description]) VALUES (N'winter18  ', N'SOEN6441  ', N'APP       ')
INSERT [dbo].[addcourse] ([Term], [Course], [Description]) VALUES (N'fall18    ', N'INSE6260  ', N'SQA       ')
INSERT [dbo].[capacity] ([Course], [Description], [Schedule], [Time], [Room], [Capacity]) VALUES (N'SOEN6441  ', N'APP                 ', N'Thursday            ', N'2:45-5:15 ', N'H409      ', N'90        ')
INSERT [dbo].[capacity] ([Course], [Description], [Schedule], [Time], [Room], [Capacity]) VALUES (N'COMP6411  ', N'Comparitive         ', N'Wednesday           ', N'5:45-8:00 ', N'H546      ', N'109       ')
INSERT [dbo].[capacity] ([Course], [Description], [Schedule], [Time], [Room], [Capacity]) VALUES (N'SOEN661   ', N'Basic Java          ', N'Monday              ', N'2:15-5:00 ', N'H411      ', N'80        ')
INSERT [dbo].[login_1] ([username], [password]) VALUES (N'student   ', N'234       ')
INSERT [dbo].[login_1] ([username], [password]) VALUES (N'admin     ', N'123       ')
INSERT [dbo].[login_1] ([username], [password]) VALUES (N'professor ', N'123       ')
INSERT [dbo].[register_student] ([Term], [Course], [Description], [Professor], [Start date], [End date], [Start time], [End time], [Vacancy]) VALUES (N'summer18  ', N'COMP6411  ', N'COMPARA   ', N'Lovish    ', N'4/07      ', N'19/08     ', N'6:30      ', N'9:00      ', N'no        ')
INSERT [dbo].[register_student] ([Term], [Course], [Description], [Professor], [Start date], [End date], [Start time], [End time], [Vacancy]) VALUES (N'fall18    ', N'INSE6260  ', N'SQA       ', N'Pf Dss    ', N'5/09      ', N'12/12     ', N'5:45      ', N'8:00      ', N'yes       ')
INSERT [dbo].[register_student] ([Term], [Course], [Description], [Professor], [Start date], [End date], [Start time], [End time], [Vacancy]) VALUES (N'winter18  ', N'SOEN6441  ', N'APP       ', N'Joey      ', N'5/09      ', N'14/12     ', N'2:45      ', N'5:15      ', N'yes       ')
INSERT [dbo].[soen6441] ([StudentID], [Grade]) VALUES (N'40013246            ', N'A         ')
INSERT [dbo].[soen6441] ([StudentID], [Grade]) VALUES (N'40013802            ', N'A         ')
INSERT [dbo].[Student] ([ID], [Name]) VALUES (N'40012344  ', N'Random    ')
INSERT [dbo].[Student] ([ID], [Name]) VALUES (N'40012345  ', N'Jyoti     ')
INSERT [dbo].[transcript] ([Term], [Course], [Description], [Grade], [GPA], [Term_GPA]) VALUES (N'Winter16  ', N'SOEN6481  ', N'SRS                 ', N'B         ', N'3.00      ', N'3.00      ')
INSERT [dbo].[transcript] ([Term], [Course], [Description], [Grade], [GPA], [Term_GPA]) VALUES (N'Winter16  ', N'SOEN6841  ', N'SPM                 ', N'A-        ', N'3.70      ', N'3.35      ')
INSERT [dbo].[transcript] ([Term], [Course], [Description], [Grade], [GPA], [Term_GPA]) VALUES (N'Summer16  ', N'SOEN6521  ', N'SCP                 ', N'B+        ', N'3.30      ', N'3.33      ')
INSERT [dbo].[transcript] ([Term], [Course], [Description], [Grade], [GPA], [Term_GPA]) VALUES (N'Summer16  ', N'SOEN6411  ', N'Comparitive Studies ', N'A-        ', N'3.70      ', N'3.425     ')
INSERT [dbo].[transcript] ([Term], [Course], [Description], [Grade], [GPA], [Term_GPA]) VALUES (N'Fall16    ', N'SOEN6461  ', N'SCM                 ', N'B+        ', N'3.30      ', N'3.4       ')
INSERT [dbo].[transcript] ([Term], [Course], [Description], [Grade], [GPA], [Term_GPA]) VALUES (N'Fall16    ', N'INSE6280  ', N'QA                  ', N'A         ', N'4         ', N'3.5       ')
INSERT [dbo].[transcript] ([Term], [Course], [Description], [Grade], [GPA], [Term_GPA]) VALUES (N'Winter17  ', N'SOEN6260  ', N'SDM                 ', NULL, NULL, NULL)
USE [master]
GO
ALTER DATABASE [sis_db] SET  READ_WRITE 
GO
