--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0
-- Dumped by pg_dump version 14.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: drug; Type: TABLE; Schema: public; Owner: nicolasvanheusden
--

CREATE TABLE public.drug (
    cip7 integer NOT NULL,
    name character varying(50),
    cis bigint
);


--
-- Name: drug drug_pkey; Type: CONSTRAINT; Schema: public; Owner: nicolasvanheusden
--

ALTER TABLE ONLY public.drug
    ADD CONSTRAINT drug_pkey PRIMARY KEY (cip7);


--
-- PostgreSQL database dump complete
--

